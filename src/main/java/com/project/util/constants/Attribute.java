package com.project.util.constants;

public class Attribute {

    // PARAMETERS
    public static final String PARAM_YEAR = "year";


    // ATTRIBUTES INTERNSHIP
    public static final String ATTR_INTERNSHIP = "internship";
    public static final String ATTR_INTERNSHIPS = "internships";
    public static final String ATTR_INTERNSHIP_FORM = "internship_form";

    // ATTRIBUTES INTERNS
    public static final String ATTR_INTERNS = "interns";

    // ATTRIBUTES SKILLS
    public static final String ATTR_SKILLS = "skills";

    // ATTRIBUTES LOGIN
    public static final String ATTR_FORM_LOGIN = "login_form";
    public static final String ATTR_USER_LOGIN = "user";

    // ATTRIBUTES DETAIL
    public static final String ATTR_FORM_DETAIL = "detail_form";

    // SESSIONS
    public static final String SESSION_USER = "SESSION_USER";

    // OTHER
    public static final String ATTR_MESSAGE = "message";
    public static final String ATTR_DATA = "data";

    // DATABASE
    public static final String DATABASE_MANAGER = "database_manager";
    public static final String PERSISTENCE_UNIT = "ST2EEDB-JEE-JPA-Version";

    // MESSAGES
    public static final String MESSAGE_ERROR_PARAM_YEAR = "Error year parameter, please try again";
    public static final String MESSAGE_CONNECTED = "Connected !";
    public static final String MESSAGE_SERVER_ERROR = "Error server, please try again !";
    public static final String MESSAGE_UPDATE_SUCCESS = "Modification updated !";
    public static final String MESSAGE_INVALID_FIELD = "Invalid field : <span class=\"font-weight-bold\">%s</span>";
    public static final String MESSAGE_EMPTY_FIELD = "<span class=\"font-weight-bold\">%s</span> cannot be empty";
    public static final String MESSAGE_GAP_DATES_ERROR = "<span class=\"font-weight-bold\">Start Date</span> must be before <span class=\"font-weight-bold\">End Date</span>";
    public static final String MESSAGE_INVALID_EMAIL = "email invalid, please enter a correct email";
    public static final String MESSAGE_EMPTY_EMAIL = "email empty, please try again";
    public static final String MESSAGE_EMPTY_PASSWORD = "password empty, please enter a password";
    public static final String MESSAGE_INVALID_PASSWORD = "password must be granter than %d characters";
    public static final String MESSAGE_POSITIVE_NUMBER = "<span class=\"font-weight-bold\">%s</span> must be a positive number";
    public static final String MESSAGE_INVALID_MID_DATE = "<span class=\"font-weight-bold\">Mid Internship Date</span> should be between internship dates";
    public static final String MESSAGE_WRONG_CREDENTIALS = "Wrong credentials, please try again !";
    public static final String MESSAGE_FAILED_LOGIN = "Login failed, please try again";

    // ERRORS
    public static final String ERROR_SERVER = "server_error";
    public static final String ERROR_PARAM_YEAR = "error_param_year";

    private Attribute() {
        throw new IllegalStateException("Utility class");
    }

}
