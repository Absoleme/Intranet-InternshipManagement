package com.project.forms;


import com.project.models.Internship;
import com.project.util.HandleEntityFields;

import javax.servlet.http.HttpServletRequest;

public class DetailForm extends Form<Internship> {


    @Override
    public Internship handleForm(HttpServletRequest request, Internship internship) {

        HandleEntityFields handleEntityFields = new HandleEntityFields();

        internship = handleEntityFields.handleInternshipFields(request, internship);

        this.setErrors(handleEntityFields.getErrors());

        if (this.getErrors().isEmpty()) {
            this.setMessage("Update succeeded !");
        } else this.setMessage("Updating failed, please verify your entries");

        return internship;

    }

}
