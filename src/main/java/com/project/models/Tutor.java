package com.project.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tutor implements Serializable {

    private static final long serialVersionUID = 4815156113686492L;

    private int tutorId;
    private String firstname;
    private String lastname;
    private String email;
    private transient String password;
    private transient Collection<com.project.models.Intern> internsByTutorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TUTOR_ID")
    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
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

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return tutorId == tutor.tutorId &&
                Objects.equals(firstname, tutor.firstname) &&
                Objects.equals(lastname, tutor.lastname) &&
                Objects.equals(email, tutor.email) &&
                Objects.equals(password, tutor.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutorId, firstname, lastname, email, password);
    }

    @OneToMany(mappedBy = "tutor")
    public Collection<com.project.models.Intern> getInternsByTutorId() {
        return internsByTutorId;
    }

    public void setInternsByTutorId(Collection<com.project.models.Intern> internsByTutorId) {
        this.internsByTutorId = internsByTutorId;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorId=" + tutorId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", internsByTutorId=" + internsByTutorId.size() +
                '}';
    }
}
