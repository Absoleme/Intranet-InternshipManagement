package com.project.exceptions;

public class ServiceException extends Exception {

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String e) {
        super(e);
    }

    public ServiceException() {
        super();
    }
}
