package com.project.forms;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public abstract class Form<T> {

    private Map<String, String> errors;
    private String message;

    public Form() {
        errors = new HashMap<>();
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void putErrors(String errorName, String value) {
        this.errors.put(errorName, value);
    }

    public T handleForm(HttpServletRequest request, T object) {
        return null;
    }

    public T handleForm(HttpServletRequest request) {
        return null;
    }
}
