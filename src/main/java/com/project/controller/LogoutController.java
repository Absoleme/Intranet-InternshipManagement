package com.project.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

import static com.project.util.constants.Attribute.SESSION_USER;
import static com.project.util.constants.Path.PATH_LOGIN;

@WebServlet(name = "LogoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LogoutController.class.getName());

    protected void removeSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(SESSION_USER) != null) {
            session.removeAttribute(SESSION_USER);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        removeSessionUser(request);
        response.sendRedirect(this.getServletContext().getContextPath() + PATH_LOGIN);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            processRequest(request, response);
        } catch (IOException exception) {
            logger.severe(exception.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            processRequest(request, response);
        } catch (IOException exception) {
            logger.severe(exception.getMessage());
        }
    }
}
