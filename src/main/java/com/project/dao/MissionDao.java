package com.project.dao;

import com.project.database.Database;
import com.project.models.Mission;

public class MissionDao extends DaoResource<Mission> {

    public MissionDao(Database database) {
        super(database, Mission.class);
    }
}
