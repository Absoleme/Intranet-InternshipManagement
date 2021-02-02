package com.project.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Company {
    private int companyId;
    private String name;
    private int streetNumber;
    private String streetName;
    private String city;
    private String zipcode;
    private Collection<com.project.models.Internship> internshipsByCompanyId;
    private Collection<com.project.models.Supervisor> internshipSupervisorsByCompanyId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "STREET_NUMBER")
    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Basic
    @Column(name = "STREET_NAME")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "ZIPCODE")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyId == company.companyId &&
                streetNumber == company.streetNumber &&
                Objects.equals(name, company.name) &&
                Objects.equals(streetName, company.streetName) &&
                Objects.equals(city, company.city) &&
                Objects.equals(zipcode, company.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, name, streetNumber, streetName, city, zipcode);
    }

    @OneToMany(mappedBy = "company")
    public Collection<com.project.models.Internship> getInternshipsByCompanyId() {
        return internshipsByCompanyId;
    }

    public void setInternshipsByCompanyId(Collection<com.project.models.Internship> internshipsByCompanyId) {
        this.internshipsByCompanyId = internshipsByCompanyId;
    }

    @OneToMany(mappedBy = "company")
    public Collection<com.project.models.Supervisor> getInternshipSupervisorsByCompanyId() {
        return internshipSupervisorsByCompanyId;
    }

    public void setInternshipSupervisorsByCompanyId(Collection<com.project.models.Supervisor> internshipSupervisorsByCompanyId) {
        this.internshipSupervisorsByCompanyId = internshipSupervisorsByCompanyId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", internshipsByCompanyId=" + internshipsByCompanyId +
                ", internshipSupervisorsByCompanyId=" + internshipSupervisorsByCompanyId +
                '}';
    }
}
