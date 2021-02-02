package com.project.services;

import com.project.dao.SupervisorDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Company;
import com.project.models.Supervisor;
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

class SupervisorServiceTest {
    private static Integer FakeSupervisorID = 0;

    @Mock
    SupervisorDao supervisorDao;

    @BeforeEach
    void setup() {
        supervisorDao = Mockito.mock(SupervisorDao.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() throws DaoException, ServiceException {
        Company fakeCompany1 = new Company();
        Company fakeCompany2 = new Company();
        Supervisor fakeSupervisor1 = createFakeSupervisor("fake1", "fake1", fakeCompany1);
        Supervisor fakeSupervisor2 = createFakeSupervisor("fake2", "fake2", fakeCompany2);
        List<Supervisor> fakeSupervisors = Arrays.asList(fakeSupervisor1, fakeSupervisor2);


        // fake behavior
        when(supervisorDao.findAll()).thenReturn(fakeSupervisors);

        SupervisorService service = new SupervisorService(supervisorDao);
        List<Supervisor> result = service.findAll();
        // assertions
        assertEquals(fakeSupervisors, result);

    }

    @Test
    void find() throws DaoException, ServiceException {
        Company fakeCompany = new Company();
        Supervisor fakeSupervisor = createFakeSupervisor("fake", "fake", fakeCompany);

        // fake behavior
        when(supervisorDao.find(1)).thenReturn(fakeSupervisor);

        SupervisorService service = new SupervisorService(supervisorDao);
        Supervisor result = service.find(1);
        // assertions
        assertEquals(fakeSupervisor, result);

    }

    @Test
    void save() throws DaoException, ServiceException {
        Company fakeCompany = new Company();
        Supervisor fakeSupervisor = createFakeSupervisor("fake", "fake", fakeCompany);

        // fake behavior
        doNothing().when(supervisorDao).save(any(Supervisor.class));

        SupervisorService service = new SupervisorService(supervisorDao);
        service.save(fakeSupervisor);
    }

    @Test
    void update() throws DaoException, ServiceException {
        Company fakeCompany = new Company();
        Supervisor fakeSupervisor = createFakeSupervisor("fake", "fake", fakeCompany);

        // fake behavior
        doNothing().when(supervisorDao).update(any(Supervisor.class));

        SupervisorService service = new SupervisorService(supervisorDao);
        service.update(fakeSupervisor);
    }

    @Test
    void updateAll() {
    }

    private Supervisor createFakeSupervisor(String firstname, String lastname, Company company) {
        Supervisor supervisor = new Supervisor();
        supervisor.setInternSupervisorId(FakeSupervisorID++);
        supervisor.setFirstname(firstname);
        supervisor.setLastname(lastname);
        supervisor.setCompany(company);
        supervisor.setInternships(new ArrayList<>());

        return supervisor;
    }
}