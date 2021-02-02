package com.project.dao;

import com.project.database.Database;
import com.project.models.Supervisor;

public class SupervisorDao extends DaoResource<Supervisor> {

    public SupervisorDao(Database database) {
        super(database, Supervisor.class);
    }
}
