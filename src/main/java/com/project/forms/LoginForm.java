package com.project.forms;

import com.project.models.Tutor;

import javax.servlet.http.HttpServletRequest;

import static com.project.util.Validation.validationEmail;
import static com.project.util.Validation.validationPassword;
import static com.project.util.constants.Attribute.MESSAGE_FAILED_LOGIN;
import static com.project.util.constants.Field.FIELD_EMAIL;
import static com.project.util.constants.Field.FIELD_PASSWORD;

public class LoginForm extends Form<Tutor> {


    public LoginForm() {
        super();
    }

    /**
     * Handle the login form to connect the user
     *
     * @param request with value of inputs
     */
    @Override
    public Tutor handleForm(HttpServletRequest request) {

        Tutor user = new Tutor();
        // get email and password from request
        String email = request.getParameter(FIELD_EMAIL);
        String password = request.getParameter(FIELD_PASSWORD);

        // validate inputs
        try {
            validationEmail(email);
        } catch (IllegalArgumentException e) {
            this.putErrors(FIELD_EMAIL, e.getMessage());
        }
        user.setEmail(email);

        try {
            validationPassword(password);
        } catch (Exception e) {
            this.putErrors(FIELD_PASSWORD, e.getMessage());
        }
        user.setPassword(password);

        if (!this.getErrors().isEmpty()) this.setMessage(MESSAGE_FAILED_LOGIN);

        return user;
    }


}
