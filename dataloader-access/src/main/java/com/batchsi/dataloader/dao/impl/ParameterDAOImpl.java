package com.batchsi.dataloader.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.batchsi.dataloader.dao.ParameterDAO;
import com.batchsi.dataloader.entities.Parameter;
import com.batchsi.dataloader.exception.ParameterNotFoundException;

@Repository
public class ParameterDAOImpl implements ParameterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Parameter findById(Long idParameter) throws ParameterNotFoundException {
        Parameter parameter = (Parameter) sessionFactory.openSession().get(Parameter.class,
                idParameter);
        if (parameter != null) {
            return parameter;
        }
        throw new ParameterNotFoundException("Parameter " + idParameter + " non trouvé !");
    }
}
