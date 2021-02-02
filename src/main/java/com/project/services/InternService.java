package com.project.services;


import com.project.dao.InternDao;
import com.project.exceptions.DaoException;
import com.project.exceptions.ServiceException;
import com.project.models.Intern;
import com.project.models.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Service class to handle Intern table
 */
public class InternService implements EntityService<Intern> {

    private final InternDao dao;

    public InternService(InternDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Intern> findAll() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public Intern find(int id) throws ServiceException {
        try {
            return dao.find(id);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void save(Intern object) throws ServiceException {
        try {
            dao.save(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void update(Intern object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void updateAll(List<Intern> objects) throws ServiceException {
        try {
            dao.updateAll(objects);
        } catch (com.project.exceptions.DaoException daoException) {
            throw new ServiceException(daoException);
        }
    }


    /**
     * Mapping a jsonObject to an intern object
     *
     * @param internJson the intern json object
     * @return Intern object
     */
    public Intern mappingJson(JSONObject internJson) {
        Intern intern = new Intern();
        intern.setInternId(internJson.getInt("id"));
        intern.setStudent(new Student());
        intern.getStudent().setStudentId(internJson.getInt("studentId"));
        JSONArray fields = internJson.getJSONArray("fields");

        fields.forEach(f -> intern.setAttributeFromJsonKey((JSONObject) f));

        return intern;
    }

}
