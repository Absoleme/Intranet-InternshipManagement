package com.project.dao;

import com.project.database.Database;
import com.project.exceptions.DaoException;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DaoResource<T> {

    final Class<T> tClass;

    protected Database database;
    protected EntityManager entityManager;

    public DaoResource(Database database, Class<T> tClass) {
        this.database = database;
        this.entityManager = this.database.getConnection();
        this.tClass = tClass;
    }

    static void close(Connection connection) throws SQLException {
        if (connection != null) connection.close();
    }

    static void close(ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
    }

    static void close(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) preparedStatement.close();
    }

    static void closeAll(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        close(connection);
        close(resultSet);
        close(preparedStatement);
    }

    public List<T> findAll() throws DaoException {
        try {
            String query = String.format("SELECT c FROM %s c", tClass.getSimpleName());
            isOpen();
            return entityManager.createQuery(query, tClass).getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            entityManager.close();
        }
    }

    public T find(int id) throws DaoException {
        isOpen();
        try {
            return entityManager.find(tClass, id);
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            entityManager.close();
        }
    }

    public void save(T object) throws DaoException {
        isOpen();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            entityManager.close();
        }
    }

    public void update(T object) throws DaoException {
        isOpen();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            entityManager.close();
        }
    }

    public void updateAll(List<T> objects) throws DaoException {
        isOpen();
        try {
            entityManager.getTransaction().begin();
            objects.forEach(entityManager::merge);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            entityManager.close();
        }
    }

    public void isOpen() {
        this.entityManager = this.entityManager.isOpen() ? this.entityManager : database.getConnection();
    }


}
