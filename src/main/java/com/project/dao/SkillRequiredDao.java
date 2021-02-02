package com.project.dao;

import com.project.database.Database;
import com.project.exceptions.DaoException;
import com.project.models.Mission;
import com.project.models.SkillRequired;

import java.util.List;

public class SkillRequiredDao extends DaoResource<SkillRequired> {


    public SkillRequiredDao(Database database) {
        super(database, SkillRequired.class);
    }

    public List<SkillRequired> findSkillRequiredByMissionId(Mission mission) throws DaoException {
        isOpen();
        try {
            return entityManager.createQuery("select i from SkillRequired i where i.missionId = :mission_id", SkillRequired.class)
                    .setParameter("mission_id", mission.getMissionId()).getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            entityManager.close();
        }
    }
}
