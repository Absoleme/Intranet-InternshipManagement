package com.project.controller;

import com.project.dao.TutorDao;
import com.project.database.DerbyDatabase;
import com.project.exceptions.ServiceException;
import com.project.forms.LoginForm;
import com.project.models.Tutor;
import com.project.services.TutorService;
import com.project.services.authentication.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.project.util.constants.Attribute.*;
import static com.project.util.constants.Path.PATH_HOME;
import static com.project.util.constants.View.VIEW_LOGIN;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        // handle forms responses
        LoginForm loginForm = new LoginForm();
        Tutor user = loginForm.handleForm(request);

        request.setAttribute(ATTR_FORM_LOGIN, loginForm);
        request.setAttribute(ATTR_USER_LOGIN, user);

        if (loginForm.getErrors().isEmpty()) {

            // use Authentication Service to check credentials
            DerbyDatabase database = DerbyDatabase.getInstance(request);
            TutorDao dao = new TutorDao(database);
            TutorService service = new TutorService(dao);
            AuthenticationService authenticationService = new AuthenticationService(service);

            // perform authentication
            Tutor userLogged = null;
            try {
                userLogged = authenticationService.authWithEmailAndPassword(user.getEmail(), user.getPassword());
            } catch (ServiceException e) {
                request.setAttribute(ERROR_SERVER, MESSAGE_SERVER_ERROR);
            }
            if (userLogged != null) {
                HttpSession session = request.getSession();
                session.setAttribute(SESSION_USER, userLogged);

                // redirection to home page
                response.sendRedirect(this.getServletContext().getContextPath() + PATH_HOME);
            } else {
                // update error message
                loginForm.setMessage(MESSAGE_WRONG_CREDENTIALS);
                request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
            }
        } else request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
    }
}
