package com.xtt.webapp;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.xtt.webapp.exception.ZipCodeNotFoundException;

@WebService(name = "CityService", serviceName = "CityService")
public interface CityService {

	List<String> getCitiesByZipCode(@WebParam(name = "zipCode") String zipCode)
			throws ZipCodeNotFoundException;

}
