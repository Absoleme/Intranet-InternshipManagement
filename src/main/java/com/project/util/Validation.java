package com.project.util;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.regex.Pattern;

import static com.project.util.constants.Attribute.*;
import static java.lang.Integer.parseInt;

/**
 * List of methods to validate field input and throw exceptions if a error is detected
 */
public class Validation {

    // Constraints
    private static final String REGEX_EMAIL = "^(.+)@(.+)$";
    private static final int MIN_CHARACTERS_FIELD = 3;

    private Validation() {
        throw new IllegalStateException("Utility Class");
    }

    public static void validationTextField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty())
            throw new IllegalArgumentException(String.format(MESSAGE_EMPTY_FIELD, fieldName));
    }

    public static int validationNumberField(String field, String fieldName) {
        if (field != null && !field.trim().isEmpty()) {
            try {
                int parseField = parseInt(field);
                if (parseField < 0) throw new NumberFormatException(String.format(MESSAGE_POSITIVE_NUMBER, fieldName));
                else return parseField;
            } catch (NumberFormatException e) {
                throw new NumberFormatException(String.format(MESSAGE_INVALID_FIELD, fieldName));
            }
        } else throw new NumberFormatException(String.format(MESSAGE_EMPTY_FIELD, fieldName));
    }

    public static Float validationFloatField(String field, String fieldName) {
        if (field != null && !field.trim().isEmpty()) {
            try {
                float parseField = Float.parseFloat(field);
                if (parseField < 0) throw new NumberFormatException(String.format(MESSAGE_POSITIVE_NUMBER, fieldName));
                else return parseField;
            } catch (NumberFormatException e) {
                throw new NumberFormatException(String.format(MESSAGE_INVALID_FIELD, fieldName));
            }
        } else throw new NullPointerException(String.format(MESSAGE_EMPTY_FIELD, fieldName));
    }

    public static Timestamp validationTimestamp(String timestamp, String fieldName) {
        if (timestamp != null && !timestamp.trim().isEmpty()) {
            try {
                return Timestamp.valueOf(timestamp.replace("T", " ") + ":00");
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format(MESSAGE_INVALID_FIELD, fieldName));
            }
        } else throw new NullPointerException(String.format(MESSAGE_EMPTY_FIELD, fieldName));
    }

    public static void validationDate(String date, String dateName) {
        if (date == null || date.trim().isEmpty())
            throw new NullPointerException(String.format(MESSAGE_EMPTY_FIELD, dateName));
    }

    /**
     * Check if start date is before the end date
     *
     * @param startDate the internship start date
     * @param endDate   the internship end date
     * @throws IllegalArgumentException if end date is before start date
     * @throws NullPointerException     if dates are null or empty
     */
    public static void validationDates(Date startDate, Date endDate) {
        if (startDate != null && endDate != null) {
            if (!startDate.before(endDate)) throw new IllegalArgumentException(MESSAGE_GAP_DATES_ERROR);
        }
    }

    public static void validationMidInternship(Date startDate, Date endDate, Timestamp midInternship) {
        validationDates(startDate, endDate);
        Date midInternshipDate = new Date(midInternship.getTime());
        if (midInternshipDate.before(startDate) || midInternshipDate.after(endDate))
            throw new IllegalArgumentException(MESSAGE_INVALID_MID_DATE);
    }

    public static void validationKeywords(String keywords, String fieldName) {
        if (keywords == null || keywords.trim().isEmpty())
            throw new IllegalArgumentException(String.format(MESSAGE_EMPTY_FIELD, fieldName));
    }

    /**
     * Check email field
     *
     * @param email from input form
     * @throws Exception throw an exception if the email is incorrect
     */
    public static void validationEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            if (!Pattern.matches(REGEX_EMAIL, email)) throw new IllegalArgumentException(MESSAGE_INVALID_EMAIL);
        } else throw new IllegalArgumentException(MESSAGE_EMPTY_EMAIL);
    }

    /**
     * Check password field
     *
     * @param password from input form
     * @throws Exception throw an exception if the password is incorrect
     */
    public static void validationPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            if (password.trim().length() < MIN_CHARACTERS_FIELD)
                throw new IllegalArgumentException(String.format(MESSAGE_INVALID_PASSWORD, MIN_CHARACTERS_FIELD));
        } else throw new IllegalArgumentException(MESSAGE_EMPTY_PASSWORD);
    }

}
