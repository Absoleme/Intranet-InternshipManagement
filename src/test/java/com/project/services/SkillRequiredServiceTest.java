package com.project.services;

import com.project.dao.SkillRequiredDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Mission;
import com.project.models.Skill;
import com.project.models.SkillRequired;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class SkillRequiredServiceTest {
    private static Integer FakeSkillID = 0;
    private static Integer FakeMissionID = 0;

    @Mock
    SkillRequiredDao skillReqDao;

    @BeforeEach
    void setup() {
        skillReqDao = Mockito.mock(SkillRequiredDao.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() throws ServiceException, DaoException {
        Skill fakeSkill1 = new Skill();
        Mission fakeMission1 = new Mission();
        Skill fakeSkill2 = new Skill();
        Mission fakeMission2 = new Mission();
        SkillRequired fakeSkillReq1 = createFakeSkillReq(fakeSkill1, fakeMission1);
        SkillRequired fakeSkillReq2 = createFakeSkillReq(fakeSkill2, fakeMission2);

        List<SkillRequired> fakeSkills = Arrays.asList(fakeSkillReq1, fakeSkillReq2);

        // fake behavior
        when(skillReqDao.findAll()).thenReturn(fakeSkills);

        SkillRequiredService service = new SkillRequiredService(skillReqDao);
        List<SkillRequired> result = service.findAll();
        // assertions
        assertEquals(fakeSkills, result);

    }

    @Test
    void find() throws DaoException, ServiceException {
        Skill fakeSkill1 = new Skill();
        Mission fakeMission1 = new Mission();

        SkillRequired fakeSkillReq = createFakeSkillReq(fakeSkill1, fakeMission1);

        // fake behavior
        when(skillReqDao.find(1)).thenReturn(fakeSkillReq);

        SkillRequiredService service = new SkillRequiredService(skillReqDao);
        SkillRequired result = service.find(1);
        // assertions
        assertEquals(fakeSkillReq, result);
    }

    @Test
    void save() throws DaoException, ServiceException {
        Skill fakeSkill1 = new Skill();
        Mission fakeMission1 = new Mission();

        SkillRequired fakeSkillReq = createFakeSkillReq(fakeSkill1, fakeMission1);

        // fake behavior
        doNothing().when(skillReqDao).save(any(SkillRequired.class));

        SkillRequiredService service = new SkillRequiredService(skillReqDao);
        service.save(fakeSkillReq);
    }

    @Test
    void update() throws ServiceException, DaoException {
        Skill fakeSkill = new Skill();
        Mission fakeMission = new Mission();

        SkillRequired fakeSkillReq = createFakeSkillReq(fakeSkill, fakeMission);

        // fake behavior
        doNothing().when(skillReqDao).update(any(SkillRequired.class));

        SkillRequiredService service = new SkillRequiredService(skillReqDao);
        service.update(fakeSkillReq);
    }

    @Test
    void updateAll() {
    }

    private SkillRequired createFakeSkillReq(Skill skill, Mission mission) {
        SkillRequired skillRequired = new SkillRequired();
        skillRequired.setMissionId(FakeSkillID++);
        skillRequired.setMissionId(FakeMissionID++);
        skillRequired.setMission(mission);
        skillRequired.setSkill(skill);
        return skillRequired;
    }
}