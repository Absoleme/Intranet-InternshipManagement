package com.project.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import static com.project.util.constants.Attribute.DATABASE_MANAGER;

public class DerbyDatabase implements Database {

    private static final String PERSISTENCE_UNIT = "ST2EEDB-JEE-JPA-Version";

    private final EntityManagerFactory managerFactory;

    public DerbyDatabase() {
        managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    public static DerbyDatabase getInstance(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        return (DerbyDatabase) servletContext.getAttribute(DATABASE_MANAGER);
    }

    @Override
    public EntityManager getConnection() {
        return managerFactory.createEntityManager();
    }

    @Override
    public void closeConnection() {
        managerFactory.close();
    }
}
