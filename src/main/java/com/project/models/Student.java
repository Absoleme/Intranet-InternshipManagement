package com.project.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Student {
    private int studentId;
    private String firstname;
    private String lastname;
    private String studentGroup;
    private Collection<Intern> internsByStudentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
    @Column(name = "STUDENT_GROUP")
    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                Objects.equals(firstname, student.firstname) &&
                Objects.equals(lastname, student.lastname) &&
                Objects.equals(studentGroup, student.studentGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstname, lastname, studentGroup);
    }

    @OneToMany(mappedBy = "student")
    public Collection<Intern> getInternsByStudentId() {
        return internsByStudentId;
    }

    public void setInternsByStudentId(Collection<Intern> internsByStudentId) {
        this.internsByStudentId = internsByStudentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                ", internsByStudentId=" + internsByStudentId +
                '}';
    }
}
