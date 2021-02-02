package com.project.dao;

import com.project.database.Database;
import com.project.exceptions.DaoException;
import com.project.models.Tutor;

public class TutorDao extends DaoResource<Tutor> {

    public TutorDao(Database database) {
        super(database, Tutor.class);
    }

    public Tutor findByEmail(String email) throws DaoException {
        isOpen();
        try {
            return entityManager.createQuery("SELECT t FROM Tutor t WHERE t.email = :email", Tutor.class).setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            entityManager.close();
        }
    }
}
