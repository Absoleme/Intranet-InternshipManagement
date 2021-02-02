package com.project.services;

import com.project.dao.InternshipDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Internship;
import com.project.models.Tutor;

import java.util.List;

public class InternshipService implements EntityService<Internship> {

    private final InternshipDao dao;

    public InternshipService(InternshipDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Internship> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public Internship find(int id) throws ServiceException {
        try {
            return dao.find(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }


    @Override
    public void save(Internship object) throws ServiceException {
        try {
            dao.save(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void update(Internship object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void updateAll(List<Internship> objects) throws ServiceException {
        try {
            dao.updateAll(objects);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    public void remove(int id) throws ServiceException {
        try {
            dao.remove(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }

    }

    // =======================
    // Custom Queries Methods
    // =======================

    public List<Internship> findInternshipsByTutorId(Tutor tutor) throws ServiceException {
        try {
            return dao.findInternshipsByTutorId(tutor);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }

    }

    public List<Internship> findByYear(Tutor tutor, int year) throws ServiceException {
        try {
            return dao.findByYear(tutor, year);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    public Internship findInternshipByTutorId(Tutor tutor) throws ServiceException {
        try {
            return dao.findInternshipByTutorId(tutor);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    // =======================
    // Custom Queries Methods
    // =======================
}
