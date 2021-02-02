package com.project.dao;

import com.project.database.Database;
import com.project.models.Skill;

public class SkillDao extends DaoResource<Skill> {

    public SkillDao(Database database) {
        super(database, Skill.class);
    }

}
