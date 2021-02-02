package com.project.forms;

import com.project.models.Internship;
import com.project.util.HandleEntityFields;

import javax.servlet.http.HttpServletRequest;

public class InternshipForm extends Form<Internship> {

    @Override
    public Internship handleForm(HttpServletRequest request) {

        HandleEntityFields handleEntityFields = new HandleEntityFields();
        Internship internship = handleEntityFields.handleInternshipFields(request);

        this.setMessage(handleEntityFields.getErrors().isEmpty() ? "Internship created !" : "Error, please try again");
        return internship;
    }

}
