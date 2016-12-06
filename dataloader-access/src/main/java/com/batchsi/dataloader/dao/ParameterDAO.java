package com.batchsi.dataloader.dao;

import com.batchsi.dataloader.entities.Parameter;
import com.batchsi.dataloader.exception.ParameterNotFoundException;

public interface ParameterDAO {

    Parameter findById(Long idParameter) throws ParameterNotFoundException;

}
