package com.project.services;

import com.project.dao.SkillRequiredDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Mission;
import com.project.models.SkillRequired;

import java.util.List;

public class SkillRequiredService implements EntityService<SkillRequired> {

    private final SkillRequiredDao dao;

    public SkillRequiredService(SkillRequiredDao dao) {
        this.dao = dao;
    }

    @Override
    public List<SkillRequired> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public SkillRequired find(int id) throws ServiceException {
        try {
            return dao.find(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void save(SkillRequired object) throws ServiceException {
        try {
            dao.save(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void update(SkillRequired object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void updateAll(List<SkillRequired> objects) throws ServiceException {
        try {
            dao.updateAll(objects);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    public List<SkillRequired> findSkillRequiredByMissionId(Mission mission) throws ServiceException {
        try {
            return dao.findSkillRequiredByMissionId(mission);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
