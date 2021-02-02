package com.project.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Internship {
    private int internshipId;
    private Date startDate;
    private Date endDate;
    private com.project.models.Intern intern;
    private Mission mission;
    private Company company;
    private Supervisor supervisor;
    private Timestamp midInternshipMeetingDate;
    private Float noteTech;
    private Float noteCom;
    private String commentaryIntern;
    private String commentarySupervisor;
    private String titleReport;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTERNSHIP_ID")
    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }

    @Basic
    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "MID_INTERNSHIP_MEETING_DATE")
    public Timestamp getMidInternshipMeetingDate() {
        return midInternshipMeetingDate;
    }

    public void setMidInternshipMeetingDate(Timestamp midInternshipMeetingDate) {
        this.midInternshipMeetingDate = midInternshipMeetingDate;
    }

    @Basic
    @Column(name = "NOTE_TECH")
    public Float getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(Float noteTech) {
        this.noteTech = noteTech;
    }

    @Basic
    @Column(name = "NOTE_COM")
    public Float getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(Float noteCom) {
        this.noteCom = noteCom;
    }

    @Basic
    @Column(name = "COMMENTARY_INTERN")
    public String getCommentaryIntern() {
        return commentaryIntern;
    }

    public void setCommentaryIntern(String internCommentary) {
        this.commentaryIntern = internCommentary;
    }

    @Basic
    @Column(name = "COMMENTARY_SUPERVISOR")
    public String getCommentarySupervisor() {
        return commentarySupervisor;
    }

    public void setCommentarySupervisor(String supervisorCommentary) {
        this.commentarySupervisor = supervisorCommentary;
    }

    @Basic
    @Column(name = "TITLE_REPORT")
    public String getTitleReport() {
        return titleReport;
    }

    public void setTitleReport(String titleReport) {
        this.titleReport = titleReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Internship that = (Internship) o;
        return internshipId == that.internshipId &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internshipId, startDate, endDate);
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INTERN_ID", referencedColumnName = "INTERN_ID", nullable = false)
    public com.project.models.Intern getIntern() {
        return intern;
    }

    public void setIntern(com.project.models.Intern intern) {
        this.intern = intern;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MISSION_ID", referencedColumnName = "MISSION_ID", nullable = false)
    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INTERN_SUPERVISOR_ID", referencedColumnName = "INTERN_SUPERVISOR_ID", nullable = false)
    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Internship{" +
                "internshipId=" + internshipId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", intern=" + intern +
                ", mission=" + mission +
                ", company=" + company +
                ", supervisor=" + supervisor +
                ", mid internship meeding date=" + midInternshipMeetingDate +
                ", note tech=" + noteTech +
                ", note comm=" + noteCom +
                ", intern commentary=" + commentaryIntern +
                ", supervisor commentary=" + commentarySupervisor +
                ", title report =" + titleReport +
                '}';
    }
}

