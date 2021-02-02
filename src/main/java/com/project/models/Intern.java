package com.project.models;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Intern {

    private int internId;
    private boolean requirement;
    private boolean visitFile;
    private boolean evalCompFile;
    private boolean webPoll;
    private boolean reportDelivered;
    private boolean defense;
    private boolean defensePlanned;
    private boolean defenseDone;
    private String linkedinUrl = "";
    private Tutor tutor;
    private com.project.models.Student student;
    private Collection<Internship> internships;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTERN_ID")
    public int getInternId() {
        return internId;
    }

    public void setInternId(int internId) {
        this.internId = internId;
    }

    @Basic
    @Column(name = "REQUIREMENT")
    public boolean isRequirement() {
        return requirement;
    }

    public void setRequirement(boolean requirement) {
        this.requirement = requirement;
    }

    @Basic
    @Column(name = "VISIT_FILE")
    public boolean isVisitFile() {
        return visitFile;
    }

    public void setVisitFile(boolean visitFile) {
        this.visitFile = visitFile;
    }

    @Basic
    @Column(name = "EVAL_COMP_FILE")
    public boolean isEvalCompFile() {
        return evalCompFile;
    }

    public void setEvalCompFile(boolean evalCompFile) {
        this.evalCompFile = evalCompFile;
    }

    @Basic
    @Column(name = "WEB_POLL")
    public boolean isWebPoll() {
        return webPoll;
    }

    public void setWebPoll(boolean webPoll) {
        this.webPoll = webPoll;
    }

    @Basic
    @Column(name = "REPORT_DELIVERED")
    public boolean isReportDelivered() {
        return reportDelivered;
    }

    public void setReportDelivered(boolean reportDelivered) {
        this.reportDelivered = reportDelivered;
    }

    @Basic
    @Column(name = "DEFENSE")
    public boolean isDefense() {
        return defense;
    }

    public void setDefense(boolean defense) {
        this.defense = defense;
    }

    @Basic
    @Column(name = "DEFENSE_PLANNED")
    public boolean isDefensePlanned() {
        return defensePlanned;
    }

    public void setDefensePlanned(boolean defensePlanned) {
        this.defensePlanned = defensePlanned;
    }

    @Basic
    @Column(name = "DEFENSE_DONE")
    public boolean isDefenseDone() {
        return defenseDone;
    }

    public void setDefenseDone(boolean defenseDone) {
        this.defenseDone = defenseDone;
    }

    @Basic
    @Column(name = "LINKEDIN_URL")
    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intern intern = (Intern) o;
        return internId == intern.internId &&
                requirement == intern.requirement &&
                visitFile == intern.visitFile &&
                evalCompFile == intern.evalCompFile &&
                webPoll == intern.webPoll &&
                reportDelivered == intern.reportDelivered &&
                defense == intern.defense &&
                defensePlanned == intern.defensePlanned &&
                defenseDone == intern.defenseDone &&
                Objects.equals(linkedinUrl, intern.linkedinUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internId, requirement, visitFile, evalCompFile, webPoll, reportDelivered, defense, defensePlanned, defenseDone, linkedinUrl);
    }

    @ManyToOne
    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID", nullable = false)
    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutorByTutorId) {
        this.tutor = tutorByTutorId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", nullable = false)
    public com.project.models.Student getStudent() {
        return student;
    }

    public void setStudent(com.project.models.Student studentByStudentId) {
        this.student = studentByStudentId;
    }

    @OneToMany(mappedBy = "intern")
    public Collection<Internship> getInternships() {
        return internships;
    }

    public void setInternships(Collection<Internship> internshipsByInternId) {
        this.internships = internshipsByInternId;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "internId=" + internId +
                ", requirement=" + requirement +
                ", visitFile=" + visitFile +
                ", evalCompFile=" + evalCompFile +
                ", webPoll=" + webPoll +
                ", reportDelivered=" + reportDelivered +
                ", defense=" + defense +
                ", defensePlanned=" + defensePlanned +
                ", defenseDone=" + defenseDone +
                ", linkedinUrl='" + linkedinUrl + '\'' +
                ", tutor=" + tutor +
                ", student=" + student +
                ", internships=" + internships +
                '}';
    }

    /**
     * Attach the corresponding json object to the correct attribute
     *
     * @param jsonObject the json object representing a field
     */
    public void setAttributeFromJsonKey(JSONObject jsonObject) {
        String value = "value";
        switch (jsonObject.getString("name")) {
            case "studentGroup":
            case "firstname":
            case "lastname":
                if (this.getStudent() == null) this.setStudent(new Student());
                this.getStudent().setStudentGroup(jsonObject.getString(value));
                break;
            case "requirement":
                this.setRequirement(jsonObject.getString(value).equals("on"));
                break;
            case "visitFile":
                this.setVisitFile(jsonObject.getString(value).equals("on"));
                break;
            case "evalCompFile":
                this.setEvalCompFile(jsonObject.getString(value).equals("on"));
                break;
            case "webPoll":
                this.setWebPoll(jsonObject.getString(value).equals("on"));
                break;
            case "reportDelivered":
                this.setReportDelivered(jsonObject.getString(value).equals("on"));
                break;
            case "defense":
                this.setDefense(jsonObject.getString(value).equals("on"));
                break;
            case "defensePlanned":
                this.setDefensePlanned(jsonObject.getString(value).equals("on"));
                break;
            case "defenseDone":
                this.setDefenseDone(jsonObject.getString(value).equals("on"));
                break;
            default:
                break;
        }
    }

}
