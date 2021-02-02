package com.project.database;

import javax.persistence.EntityManager;

public interface Database {

    EntityManager getConnection();

    void closeConnection();

}
