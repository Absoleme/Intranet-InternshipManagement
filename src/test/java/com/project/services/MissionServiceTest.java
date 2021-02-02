package com.project.services;

import com.project.dao.MissionDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Mission;
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

class MissionServiceTest {

    private static Integer FakeMissionID = 0;

    @Mock
    MissionDao missionDao;

    @BeforeEach
    void setup() {
        missionDao = Mockito.mock(MissionDao.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() throws DaoException, ServiceException {
        Mission fakeMission1 = createFakeMission("fakeDesc", "fakeKey");
        Mission fakeMission2 = createFakeMission("fakeDescription", "fakeKeyword");
        List<Mission> fakeMissions = Arrays.asList(fakeMission1, fakeMission2);

        // fake behavior
        when(missionDao.findAll()).thenReturn(fakeMissions);

        MissionService service = new MissionService(missionDao);
        List<Mission> result = service.findAll();
        // assertions
        assertEquals(fakeMissions, result);
    }

    @Test
    void find() throws DaoException, ServiceException {
        Mission fakeMission = createFakeMission("fakeDesc", "fakeKey");

        // fake behavior
        when(missionDao.find(1)).thenReturn(fakeMission);

        MissionService service = new MissionService(missionDao);
        Mission result = service.find(1);
        // assertions
        assertEquals(fakeMission, result);
    }

    @Test
    void save() throws DaoException, ServiceException {
        Mission fakeMission = createFakeMission("fakeDesc", "fakeKey");

        // fake behavior
        doNothing().when(missionDao).save(any(Mission.class));

        MissionService service = new MissionService(missionDao);
        service.save(fakeMission);
    }

    @Test
    void saveAll() {
    }

    @Test
    void update() throws DaoException, ServiceException {
        Mission fakeMission = createFakeMission("fakeDesc", "fakeKey");

        // fake behavior
        doNothing().when(missionDao).update(any(Mission.class));

        MissionService service = new MissionService(missionDao);
        service.update(fakeMission);

    }

    @Test
    void updateAll() {
    }

    private Mission createFakeMission(String description, String keyWords) {
        Mission mission = new Mission();
        mission.setMissionId(FakeMissionID++);
        mission.setDescription(description);
        mission.setKeyWords(keyWords);
        mission.setInternshipsByMissionId(new ArrayList<>());
        mission.setSkills(new ArrayList<>());
        return mission;
    }
}