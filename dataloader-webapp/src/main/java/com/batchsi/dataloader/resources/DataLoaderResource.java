package com.batchsi.dataloader.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.batchsi.dataloader.dao.ParameterDAO;
import com.batchsi.dataloader.entities.Parameter;
import com.batchsi.dataloader.exception.ParameterNotFoundException;

@RestController
@RequestMapping(value = "parameter")
public class DataLoaderResource {

    @Autowired
    private ParameterDAO parameterDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Parameter getParameterById(@PathVariable String id) throws ParameterNotFoundException {
        return parameterDAO.findById(Long.parseLong(id));
    }

}
