package com.project.controller;

import com.project.dao.InternshipDao;
import com.project.database.DerbyDatabase;
import com.project.forms.InternshipForm;
import com.project.models.Internship;
import com.project.models.Tutor;
import com.project.services.InternshipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

import static com.project.util.constants.Attribute.*;
import static com.project.util.constants.Path.PATH_HOME;
import static com.project.util.constants.View.VIEW_INTERNSHIP;

@WebServlet(name = "InternshipController", urlPatterns = {"/internship"})
public class InternshipController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(InternshipController.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        Tutor user = (Tutor) request.getSession().getAttribute(SESSION_USER);

        InternshipForm internshipForm = new InternshipForm();
        Internship internship = internshipForm.handleForm(request);

        request.setAttribute(ATTR_INTERNSHIP_FORM, internshipForm);

        // check errors and redirect to home if not
        if (internshipForm.getErrors().isEmpty()) {
            try {

                DerbyDatabase database = DerbyDatabase.getInstance(request);
                InternshipDao dao = new InternshipDao(database);
                InternshipService service = new InternshipService(dao);
                internship.getIntern().setTutor(user);
                service.save(internship);

                response.sendRedirect(this.getServletContext().getContextPath() + PATH_HOME);

            } catch (Exception e) {
                logger.severe(e.getMessage());
                request.setAttribute(ATTR_INTERNSHIP, internship);
                response.sendRedirect(this.getServletContext().getContextPath() + PATH_HOME);

            }
        } else {
            // TODO feedback error attribute
            // display the form with errors
            request.setAttribute(ATTR_INTERNSHIP, internship);
            request.getRequestDispatcher(VIEW_INTERNSHIP).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        request.getRequestDispatcher(VIEW_INTERNSHIP).forward(request, response);
    }
}
