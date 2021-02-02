package com.project.services;

import com.project.dao.StudentDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    private static Integer FakeStudentID = 0;

    @Mock
    StudentDao studentDao;

    @BeforeEach
    void setup() {
        studentDao = Mockito.mock(StudentDao.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() throws DaoException, ServiceException {
        Student fakeStudent1 = createFakeStudent("fake1", "fake1", "fake1");
        Student fakeStudent2 = createFakeStudent("fake2", "fake2", "fake2");
        List<Student> fakeStudents = Arrays.asList(fakeStudent1, fakeStudent2);

        // fake behavior
        when(studentDao.findAll()).thenReturn(fakeStudents);

        StudentService service = new StudentService(studentDao);
        List<Student> result = service.findAll();
        // assertions
        assertEquals(fakeStudents, result);
    }

    @Test
    void find() throws ServiceException, DaoException {
        Student fakeStudent = createFakeStudent("fake", "fake", "fake");

        // fake behavior
        when(studentDao.find(1)).thenReturn(fakeStudent);

        StudentService service = new StudentService(studentDao);
        Student result = service.find(1);
        // assertions
        assertEquals(fakeStudent, result);
    }

    @Test
    void save() throws DaoException, ServiceException {
        Student fakeStudent = createFakeStudent("fake", "fake", "fake");


        // fake behavior
        doNothing().when(studentDao).save(any(Student.class));

        StudentService service = new StudentService(studentDao);
        service.save(fakeStudent);
    }

    @Test
    void update() throws ServiceException, DaoException {
        Student fakeStudent = createFakeStudent("fake", "fake", "fake");

        // fake behavior
        doNothing().when(studentDao).update(any(Student.class));

        StudentService service = new StudentService(studentDao);
        service.update(fakeStudent);
    }

    @Test
    void updateAll() {
    }

    private Student createFakeStudent(String firstname, String lastname, String studentGroup) {
        Student student = new Student();
        student.setStudentId(FakeStudentID++);
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setStudentGroup(studentGroup);
        student.setInternsByStudentId(new ArrayList<>());

        return student;
    }
}