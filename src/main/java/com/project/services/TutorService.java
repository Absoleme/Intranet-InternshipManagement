package com.project.services;

import com.project.dao.TutorDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Tutor;

import java.util.List;

public class TutorService implements EntityService<Tutor> {

    private final TutorDao dao;

    public TutorService(TutorDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Tutor> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public Tutor find(int id) throws ServiceException {
        try {
            return dao.find(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void save(Tutor object) throws ServiceException {
        try {
            dao.save(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void update(Tutor object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void updateAll(List<Tutor> objects) throws ServiceException {
        try {
            dao.updateAll(objects);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    public Tutor findByEmail(String email) throws ServiceException {
        try {
            return dao.findByEmail(email);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }

    }
}
