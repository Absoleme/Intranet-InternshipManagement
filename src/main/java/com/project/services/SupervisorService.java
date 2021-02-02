package com.project.services;

import com.project.dao.SupervisorDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Supervisor;

import java.util.List;

public class SupervisorService implements EntityService<Supervisor> {


    private final SupervisorDao dao;

    public SupervisorService(SupervisorDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Supervisor> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public Supervisor find(int id) throws ServiceException {
        try {
            return dao.find(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void save(Supervisor object) throws ServiceException {
        try {
            dao.save(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void update(Supervisor object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void updateAll(List<Supervisor> objects) throws ServiceException {
        try {
            dao.updateAll(objects);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

}
