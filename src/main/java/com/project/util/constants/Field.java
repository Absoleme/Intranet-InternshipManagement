package com.project.util.constants;

public class Field {

    // STUDENT FIELDS
    public static final String FIELD_STUDENT_FIRSTNAME = "studentFirstname";
    public static final String FIELD_STUDENT_LASTNAME = "studentLastname";
    public static final String FIELD_STUDENT_GROUP = "studentGroup";
    public static final String FIELD_LINKEDIN_URL = "linkedinUrl";
    // SUPERVISOR FIELDS
    public static final String FIELD_SUPERVISOR_FIRSTNAME = "supervisorFirstname";
    public static final String FIELD_SUPERVISOR_LASTNAME = "supervisorLastname";
    // COMPANY FIELDS
    public static final String FIELD_COMPANY_NAME = "companyName";
    public static final String FIELD_COMPANY_STREET_NUMBER = "companyStreetNumber";
    public static final String FIELD_COMPANY_STREET_NAME = "companyStreetName";
    public static final String FIELD_COMPANY_CITY = "companyCity";
    public static final String FIELD_COMPANY_ZIPCODE = "companyZipCode";
    // INTERNSHIP FIELDS
    public static final String FIELD_START_DATE = "startDate";
    public static final String FIELD_END_DATE = "endDate";
    public static final String FIELD_INTERNSHIP_DATES = "internshipDates";
    public static final String FIELD_COMMENTARY_INTERN = "commentaryIntern";
    public static final String FIELD_COMMENTARY_SUPERVISOR = "commentarySupervisor";
    public static final String FIELD_NOTE_TECH = "noteTech";
    public static final String FIELD_NOTE_COM = "noteCom";
    public static final String FIELD_MID_INTERNSHIP_MEETING_DATE = "midInternshipMeetingDate";
    public static final String FIELD_TITLE_REPORT = "titleReport";
    public static final String FIELD_REQUIREMENT = "requirement";
    public static final String FIELD_VISIT_FILE = "visitFile";
    public static final String FIELD_EVAL_COMP_FILE = "evalCompFile";
    public static final String FIELD_WEB_POLL = "webPoll";
    public static final String FIELD_REPORT_DELIVERED = "reportDelivered";
    public static final String FIELD_DEFENSE = "defense";
    public static final String FIELD_DEFENSE_PLANNED = "defensePlanned";
    public static final String FIELD_DEFENSE_DONE = "defenseDone";
    // MISSION FIELDS
    public static final String FIELD_MISSION_DESCRIPTION = "missionDescription";
    public static final String FIELD_MISSION_KEYWORDS = "missionKeywords";
    // SKILLS
    public static final String FIELD_SKILLS_REQUIRED = "skillsRequired";
    // LOGIN FIELDS
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PASSWORD = "password";

    private Field() {
        throw new IllegalStateException("Utility class");
    }

}
