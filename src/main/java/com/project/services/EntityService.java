package com.project.services;

import com.project.exceptions.ServiceException;

import java.util.List;

public interface EntityService<X> {

    List<X> findAll() throws ServiceException;

    X find(int id) throws ServiceException;

    void save(X object) throws ServiceException;

    void update(X object) throws ServiceException;

    void updateAll(List<X> objects) throws ServiceException;

}
