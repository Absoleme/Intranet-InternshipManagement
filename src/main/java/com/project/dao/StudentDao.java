package com.project.dao;

import com.project.database.Database;
import com.project.models.Student;

public class StudentDao extends DaoResource<Student> {

    public StudentDao(Database database) {
        super(database, Student.class);
    }

}
