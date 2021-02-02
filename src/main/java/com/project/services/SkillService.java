package com.project.services;

import com.project.dao.SkillDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Skill;

import java.util.List;

public class SkillService implements EntityService<Skill> {

    private final SkillDao dao;

    public SkillService(SkillDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Skill> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public Skill find(int id) throws ServiceException {
        try {
            return dao.find(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void save(Skill object) throws ServiceException {
        try {
            dao.save(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void update(Skill object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void updateAll(List<Skill> objects) throws ServiceException {
        try {
            dao.updateAll(objects);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }
}
