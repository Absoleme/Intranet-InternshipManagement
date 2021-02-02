package com.project.services;

import com.project.dao.SkillDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Skill;
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

class SkillServiceTest {

    private static Integer FakeSkillID = 0;

    @Mock
    SkillDao skillDao;

    @BeforeEach
    void setup() {
        skillDao = Mockito.mock(SkillDao.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() throws DaoException, ServiceException {
        Skill fakeSkill1 = createFakeSkill("fake");
        Skill fakeSkill2 = createFakeSkill("fake");
        List<Skill> fakeSkills = Arrays.asList(fakeSkill1, fakeSkill2);

        // fake behavior
        when(skillDao.findAll()).thenReturn(fakeSkills);

        SkillService service = new SkillService(skillDao);
        List<Skill> result = service.findAll();
        // assertions
        assertEquals(fakeSkills, result);
    }

    @Test
    void find() throws ServiceException, DaoException {
        Skill fakeSkill = createFakeSkill("fake");

        // fake behavior
        when(skillDao.find(1)).thenReturn(fakeSkill);

        SkillService service = new SkillService(skillDao);
        Skill result = service.find(1);
        // assertions
        assertEquals(fakeSkill, result);
    }

    @Test
    void save() throws DaoException, ServiceException {
        Skill fakeSkill = createFakeSkill("fake");

        // fake behavior
        doNothing().when(skillDao).save(any(Skill.class));

        SkillService service = new SkillService(skillDao);
        service.save(fakeSkill);
    }

    @Test
    void saveAll() {
    }

    @Test
    void update() throws DaoException, ServiceException {
        Skill fakeSkill = createFakeSkill("fake");

        // fake behavior
        doNothing().when(skillDao).save(any(Skill.class));

        SkillService service = new SkillService(skillDao);
        service.update(fakeSkill);
    }

    @Test
    void updateAll() {
    }

    private Skill createFakeSkill(String name) {
        Skill skill = new Skill();
        skill.setSkillId(FakeSkillID++);
        skill.setName(name);
        skill.setSkillRequireds(new ArrayList<>());
        return skill;
    }
}