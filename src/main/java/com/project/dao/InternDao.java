package com.project.dao;


import com.project.database.Database;
import com.project.models.Intern;

/**
 * Service class to handle Intern table
 */
public class InternDao extends DaoResource<Intern> {

    public InternDao(Database database) {
        super(database, Intern.class);
    }

}
