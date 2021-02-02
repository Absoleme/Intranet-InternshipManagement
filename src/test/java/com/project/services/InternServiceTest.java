package com.project.services;

import com.project.dao.InternDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Intern;
import com.project.models.Student;
import com.project.models.Tutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class InternServiceTest {

    private static Integer FakeInternID = 0;

    @Mock
    InternDao internDao;

    @BeforeEach
    void setUp() {
        internDao = Mockito.mock(InternDao.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() throws SQLException, DaoException, ServiceException {
        Student fakeStudent = new Student();
        Tutor fakeTutor = new Tutor();
        Intern fakeIntern1 = createFakeIntern(false, true, false, true, false, true, true, true, "fakeUrl", fakeTutor, fakeStudent);

        List<Intern> fakeInterns = Arrays.asList(fakeIntern1);

        // fake behavior
        when(internDao.findAll()).thenReturn(fakeInterns);

        InternService service = new InternService(internDao);
        List<Intern> result = service.findAll();
        // assertions
        assertEquals(fakeInterns, result);
    }

    @Test
    void find() throws DaoException, ServiceException {
        Student fakeStudent = new Student();
        Tutor fakeTutor = new Tutor();
        Intern fakeIntern = createFakeIntern(false, true, false, true, false, true, true, true, "fakeUrl", fakeTutor, fakeStudent);

        // fake behavior
        when(internDao.find(1)).thenReturn(fakeIntern);

        InternService service = new InternService(internDao);
        Intern result = service.find(1);
        // assertions
        assertEquals(fakeIntern, result);
    }

    @Test
    void save() throws DaoException, ServiceException {
        Student fakeStudent = new Student();
        Tutor fakeTutor = new Tutor();
        Intern fakeIntern = createFakeIntern(false, true, false, true, false, true, true, true, "fakeUrl", fakeTutor, fakeStudent);

        // fake behavior
        doNothing().when(internDao).save(any(Intern.class));

        InternService service = new InternService(internDao);
        service.save(fakeIntern);
    }

    @Test
    void update() throws DaoException, ServiceException {
        Student fakeStudent = new Student();
        Tutor fakeTutor = new Tutor();
        Intern fakeIntern = createFakeIntern(false, true, false, true, false, true, true, true, "fakeUrl", fakeTutor, fakeStudent);

        // fake behavior
        doNothing().when(internDao).update(any(Intern.class));

        InternService service = new InternService(internDao);
        service.update(fakeIntern);
    }

    @Test
    void updateAll() {
    }

    @Test
    void mappingJson() {
    }

    private Intern createFakeIntern(boolean requirement, boolean visitFile, boolean evalCompFile, boolean webPoll, boolean reportDelivered, boolean defense, boolean defensePlanned, boolean defenseDone, String linkedinUrl, Tutor tutor, Student student) {
        Intern intern = new Intern();
        intern.setInternId(FakeInternID++);
        intern.setDefense(defense);
        intern.setDefenseDone(defenseDone);
        intern.setDefensePlanned(defensePlanned);
        intern.setEvalCompFile(evalCompFile);
        intern.setLinkedinUrl(linkedinUrl);
        intern.setRequirement(requirement);
        intern.setTutor(tutor);
        intern.setWebPoll(webPoll);
        intern.setVisitFile(visitFile);
        intern.setStudent(student);
        intern.setReportDelivered(reportDelivered);
        intern.setInternships(new ArrayList<>());

        return intern;
    }
}