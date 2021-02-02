package com.project.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "INTERNSHIP_SUPERVISOR", schema = "ADM", catalog = "")
public class Supervisor {
    private int internSupervisorId;
    private String firstname;
    private String lastname;
    private Collection<com.project.models.Internship> internships;
    private Company company;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTERN_SUPERVISOR_ID")
    public int getInternSupervisorId() {
        return internSupervisorId;
    }

    public void setInternSupervisorId(int internSupervisorId) {
        this.internSupervisorId = internSupervisorId;
    }

    @Basic
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supervisor that = (Supervisor) o;
        return internSupervisorId == that.internSupervisorId &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internSupervisorId, firstname, lastname);
    }

    @OneToMany(mappedBy = "supervisor")
    public Collection<com.project.models.Internship> getInternships() {
        return internships;
    }

    public void setInternships(Collection<com.project.models.Internship> internships) {
        this.internships = internships;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID", nullable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "InternshipSupervisor{" +
                "internSupervisorId=" + internSupervisorId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", internshipsByInternSupervisorId=" + internships +
                ", companyByCompanyId=" + company +
                '}';
    }
}
