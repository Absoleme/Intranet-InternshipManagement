package com.project.services;

import com.project.dao.StudentDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Student;

import java.util.List;

public class StudentService implements EntityService<Student> {

    private final StudentDao dao;

    public StudentService(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Student> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public Student find(int id) throws ServiceException {
        try {
            return dao.find(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void save(Student object) throws ServiceException {
        try {
            dao.save(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void update(Student object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void updateAll(List<Student> objects) throws ServiceException {
        try {
            dao.updateAll(objects);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

}
