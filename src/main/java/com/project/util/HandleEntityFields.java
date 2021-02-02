package com.project.util;

import com.project.dao.SkillDao;
import com.project.database.DerbyDatabase;
import com.project.exceptions.ServiceException;
import com.project.models.*;
import com.project.services.SkillService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import static com.project.util.Validation.*;
import static com.project.util.constants.Attribute.*;
import static com.project.util.constants.Field.*;

/**
 * List of methods to handle form fields and mapping to the correct class
 */
public class HandleEntityFields {

    // to stock errors from try / catch
    private final Map<String, String> errors;

    public HandleEntityFields() {
        errors = new HashMap<>();
    }

    public Map<String, String> getErrors() {
        return errors;
    }


    // Methods

    public Internship handleInternshipFields(HttpServletRequest request) {
        return handleInternshipFields(request, new Internship());
    }

    public Student handleStudentFields(HttpServletRequest request) {
        return handleStudentFields(request, new Student());
    }

    public Intern handleInternFields(HttpServletRequest request) {
        return handleInternFields(request, new Intern());
    }

    public Company handleCompanyFields(HttpServletRequest request) {
        return handleCompanyFields(request, new Company());
    }

    public Supervisor handleSupervisorFields(HttpServletRequest request) {
        return handleSupervisorFields(request, new Supervisor());
    }

    public Mission handleMissionFields(HttpServletRequest request) {
        return handleMissionFields(request, new Mission());
    }

    public Internship handleInternshipFields(HttpServletRequest request, Internship internship) {

        if (internship == null) {
            internship = new Internship();
        }

        Date startDate = null;
        Date endDate = null;
        String startDateString = request.getParameter(FIELD_START_DATE);
        String endDateString = request.getParameter(FIELD_END_DATE);
        String commentaryIntern = request.getParameter(FIELD_COMMENTARY_INTERN) == null ? null : request.getParameter(FIELD_COMMENTARY_INTERN);
        String commentarySupervisor = request.getParameter(FIELD_COMMENTARY_SUPERVISOR) == null ? null : request.getParameter(FIELD_COMMENTARY_SUPERVISOR);
        String titleReport = request.getParameter(FIELD_TITLE_REPORT) == null ? null : request.getParameter(FIELD_TITLE_REPORT);

        Float noteTechParse;
        Float noteComParse;
        String noteTech = request.getParameter(FIELD_NOTE_TECH) == null ? null : request.getParameter(FIELD_NOTE_TECH);
        String noteCom = request.getParameter(FIELD_NOTE_COM) == null ? null : request.getParameter(FIELD_NOTE_COM);

        // Start date validation
        try {
            validationDate(startDateString, FIELD_START_DATE);
            startDate = Date.valueOf(request.getParameter(FIELD_START_DATE));
        } catch (NullPointerException | IllegalArgumentException e) {
            errors.put(FIELD_START_DATE, e.getMessage());
        }

        // End date validation
        try {
            validationDate(endDateString, FIELD_END_DATE);
            endDate = Date.valueOf(request.getParameter(FIELD_END_DATE));
        } catch (NullPointerException | IllegalArgumentException e) {
            errors.put(FIELD_END_DATE, e.getMessage());
        }

        // Dates validation
        try {
            validationDates(startDate, endDate);
        } catch (IllegalArgumentException e) {
            errors.put(FIELD_INTERNSHIP_DATES, e.getMessage());
        }
        internship.setStartDate(startDate);
        internship.setEndDate(endDate);

        // String datetime to timestamp
        Timestamp midInternshipMeetingDate;
        String midInternshipMeetingDateS = request.getParameter(FIELD_MID_INTERNSHIP_MEETING_DATE) == null ? null : request.getParameter(FIELD_MID_INTERNSHIP_MEETING_DATE);
        try {
            midInternshipMeetingDate = validationTimestamp(midInternshipMeetingDateS, FIELD_MID_INTERNSHIP_MEETING_DATE);
            internship.setMidInternshipMeetingDate(midInternshipMeetingDate);
            validationMidInternship(startDate, endDate, midInternshipMeetingDate);
        } catch (IllegalArgumentException e) {
            errors.put(FIELD_MID_INTERNSHIP_MEETING_DATE, e.getMessage());
        } catch (NullPointerException ignored) {
            internship.setMidInternshipMeetingDate(null);
        }

        // Note tech validation
        try {
            noteTechParse = validationFloatField(noteTech, FIELD_NOTE_TECH);
            internship.setNoteTech(noteTechParse);
        } catch (NumberFormatException e) {
            errors.put(FIELD_NOTE_TECH, e.getMessage());
        } catch (NullPointerException ignored) {
            internship.setNoteTech(null);
        }

        // Note com validation
        try {
            noteComParse = validationFloatField(noteCom, FIELD_NOTE_COM);
            internship.setNoteCom(noteComParse);
        } catch (NumberFormatException e) {
            errors.put(FIELD_NOTE_COM, e.getMessage());
        } catch (NullPointerException ignored) {
            internship.setNoteCom(null);
        }


        // Optional fields
        internship.setCommentaryIntern(commentaryIntern);
        internship.setCommentarySupervisor(commentarySupervisor);
        internship.setTitleReport(titleReport);

        // Relation fields
        internship.setIntern(handleInternFields(request, internship.getIntern()));
        internship.getIntern().setStudent(handleStudentFields(request, internship.getIntern().getStudent()));
        internship.setCompany(handleCompanyFields(request, internship.getCompany()));
        internship.setSupervisor(handleSupervisorFields(request, internship.getSupervisor()));
        internship.getSupervisor().setCompany(internship.getCompany());
        internship.setMission(handleMissionFields(request, internship.getMission()));

        return internship;
    }

    public Student handleStudentFields(HttpServletRequest request, Student student) {

        if (student == null) {
            student = new Student();
        }
        // request parameters
        String firstname = request.getParameter(FIELD_STUDENT_FIRSTNAME);
        String lastname = request.getParameter(FIELD_STUDENT_LASTNAME);
        String studentGroup = request.getParameter(FIELD_STUDENT_GROUP);


        // Firstname validation
        try {
            validationTextField(firstname, FIELD_STUDENT_FIRSTNAME);
        } catch (Exception e) {
            errors.put(FIELD_STUDENT_FIRSTNAME, e.getMessage());
        }
        student.setFirstname(firstname);

        // Lastname validation
        try {
            validationTextField(lastname, FIELD_STUDENT_LASTNAME);
        } catch (Exception e) {
            errors.put(FIELD_STUDENT_LASTNAME, e.getMessage());
        }
        student.setLastname(lastname);

        // Student group validation
        try {
            validationTextField(request.getParameter(FIELD_STUDENT_GROUP), FIELD_STUDENT_GROUP);
        } catch (Exception e) {
            errors.put(FIELD_STUDENT_GROUP, e.getMessage());
        }
        student.setStudentGroup(studentGroup);
        return student;
    }

    public Intern handleInternFields(HttpServletRequest request, Intern intern) {

        if (intern == null) {
            intern = new Intern();
        }

        // request parameters
        boolean requirement = request.getParameter(FIELD_REQUIREMENT) != null && request.getParameter(FIELD_REQUIREMENT).contains("on");
        boolean visitFile = request.getParameter(FIELD_VISIT_FILE) != null && request.getParameter(FIELD_VISIT_FILE).contains("on");
        boolean evalCompFile = request.getParameter(FIELD_EVAL_COMP_FILE) != null && request.getParameter(FIELD_EVAL_COMP_FILE).contains("on");
        boolean webPoll = request.getParameter(FIELD_WEB_POLL) != null && request.getParameter(FIELD_WEB_POLL).contains("on");
        boolean reportDelivered = request.getParameter(FIELD_REPORT_DELIVERED) != null && request.getParameter(FIELD_REPORT_DELIVERED).contains("on");
        boolean defense = request.getParameter(FIELD_DEFENSE) != null && request.getParameter(FIELD_DEFENSE).contains("on");
        boolean defensePlanned = request.getParameter(FIELD_DEFENSE_PLANNED) != null && request.getParameter(FIELD_DEFENSE_PLANNED).contains("on");
        boolean defenseDone = request.getParameter(FIELD_DEFENSE_DONE) != null && request.getParameter(FIELD_DEFENSE_DONE).contains("on");

        String linkedinUrl = request.getParameter(FIELD_LINKEDIN_URL);

        intern.setRequirement(requirement);
        intern.setVisitFile(visitFile);
        intern.setEvalCompFile(evalCompFile);
        intern.setWebPoll(webPoll);
        intern.setReportDelivered(reportDelivered);
        intern.setDefense(defense);
        intern.setDefensePlanned(defensePlanned);
        intern.setDefenseDone(defenseDone);
        intern.setLinkedinUrl(linkedinUrl);

        return intern;

    }

    public Company handleCompanyFields(HttpServletRequest request, Company company) {

        if (company == null) {
            company = new Company();
        }

        String name = request.getParameter(FIELD_COMPANY_NAME) == null ? company.getName() : request.getParameter(FIELD_COMPANY_NAME);
        String streetName = request.getParameter(FIELD_COMPANY_STREET_NAME) == null ? company.getStreetName() : request.getParameter(FIELD_COMPANY_STREET_NAME);
        String city = request.getParameter(FIELD_COMPANY_CITY) == null ? company.getCity() : request.getParameter(FIELD_COMPANY_CITY);
        String zipCode = request.getParameter(FIELD_COMPANY_ZIPCODE) == null ? company.getZipcode() : request.getParameter(FIELD_COMPANY_ZIPCODE);
        String streetNumber = request.getParameter(FIELD_COMPANY_STREET_NUMBER) == null ? String.valueOf(company.getStreetNumber()) : request.getParameter(FIELD_COMPANY_STREET_NUMBER);

        int streetNumberParse = 0;

        // Name validation
        try {
            validationTextField(name, FIELD_COMPANY_NAME);
        } catch (Exception e) {
            errors.put(FIELD_COMPANY_NAME, e.getMessage());
        }
        company.setName(name);

        // Street name validation
        try {
            validationTextField(streetName, FIELD_COMPANY_STREET_NAME);
        } catch (Exception e) {
            errors.put(FIELD_COMPANY_STREET_NAME, e.getMessage());
        }
        company.setStreetName(streetName);

        // City validation
        try {
            validationTextField(city, FIELD_COMPANY_CITY);
        } catch (Exception e) {
            errors.put(FIELD_COMPANY_CITY, e.getMessage());
        }
        company.setCity(city);

        // Zipcode validation
        try {
            validationTextField(zipCode, FIELD_COMPANY_ZIPCODE);
        } catch (Exception e) {
            errors.put(FIELD_COMPANY_ZIPCODE, e.getMessage());
        }
        company.setZipcode(zipCode);

        // Street number validation

        try {
            streetNumberParse = validationNumberField(streetNumber, FIELD_COMPANY_STREET_NUMBER);
        } catch (NumberFormatException e) {
            errors.put(FIELD_COMPANY_STREET_NUMBER, e.getMessage());
        }
        company.setStreetNumber(streetNumberParse);

        return company;
    }

    public Supervisor handleSupervisorFields(HttpServletRequest request, Supervisor supervisor) {

        if (supervisor == null) {
            supervisor = new Supervisor();
        }

        // request parameters
        String firstname = request.getParameter(FIELD_SUPERVISOR_FIRSTNAME);
        String lastname = request.getParameter(FIELD_SUPERVISOR_LASTNAME);

        // Firstname validation
        try {
            validationTextField(firstname, FIELD_SUPERVISOR_FIRSTNAME);
        } catch (Exception e) {
            errors.put(FIELD_SUPERVISOR_FIRSTNAME, e.getMessage());
        }
        supervisor.setFirstname(firstname);

        // Lastname validation
        try {
            validationTextField(lastname, FIELD_SUPERVISOR_LASTNAME);
        } catch (Exception e) {
            errors.put(FIELD_SUPERVISOR_LASTNAME, e.getMessage());
        }
        supervisor.setLastname(lastname);

        return supervisor;
    }

    public Mission handleMissionFields(HttpServletRequest request, Mission mission) {

        if (mission == null) {
            mission = new Mission();
        }

        // request parameters
        String description = request.getParameter(FIELD_MISSION_DESCRIPTION);
        String keywords = request.getParameter(FIELD_MISSION_KEYWORDS);


        Mission finalMission = mission;
        List<SkillRequired> skills = new ArrayList<>();
        try {
            skills = Arrays.asList(request.getParameter(FIELD_SKILLS_REQUIRED).split(",")).stream().map(sk -> {
                List<Skill> l = new ArrayList<>();
                try {
                    l = new SkillService(new SkillDao(DerbyDatabase.getInstance(request))).findAll();
                } catch (ServiceException e) {
                    request.setAttribute(ERROR_SERVER, MESSAGE_ERROR_PARAM_YEAR);
                }
                SkillRequired skillRequired = new SkillRequired();
                for (Skill s : l) {
                    if (s.getName().equals(sk)) {
                        skillRequired.setSkillId(s.getSkillId());
                    }
                }
                if (skillRequired.getSkillId() == 0) {
                    Skill newSkill = new Skill();
                    newSkill.setName(sk);
                    l.add(newSkill);
                    try {
                        new SkillService(new SkillDao(DerbyDatabase.getInstance((request)))).save(newSkill);
                    } catch (ServiceException e) {
                        request.setAttribute(ERROR_SERVER, MESSAGE_SERVER_ERROR);
                    }
                    skillRequired.setSkillId(newSkill.getSkillId());
                }
                skillRequired.setMissionId(finalMission.getMissionId());
                return skillRequired;
            }).collect(Collectors.toList());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        mission.setSkills(skills);


        // Description validation
        try {
            validationTextField(description, FIELD_MISSION_DESCRIPTION);
        } catch (Exception e) {
            errors.put(FIELD_MISSION_DESCRIPTION, e.getMessage());
        }
        mission.setDescription(description);

        mission.setKeyWords(keywords);

        return mission;
    }


}
