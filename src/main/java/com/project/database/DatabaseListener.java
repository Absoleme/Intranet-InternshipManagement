package com.project.database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

import static com.project.util.constants.Attribute.DATABASE_MANAGER;

@WebListener()
public class DatabaseListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static final Logger logger = Logger.getLogger(DatabaseListener.class.getName());

    // Public constructor is required by servlet spec
    public DatabaseListener() {
        // Do nothing
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        DerbyDatabase derbyDatabase = new DerbyDatabase();
        sce.getServletContext().setAttribute(DATABASE_MANAGER, derbyDatabase);
        logger.fine("Connection to database open !");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        DerbyDatabase database = (DerbyDatabase) sce.getServletContext().getAttribute(DATABASE_MANAGER);
        database.closeConnection();
        logger.fine("Connection to database close !");
    }

}
