package com.xtt.webapp.impl;

import java.util.List;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xtt.webapp.zipcodes.GetCityRequest;
import com.xtt.webapp.zipcodes.GetCityResponse;

@Endpoint
public class CityService {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCityRequest")
	@ResponsePayload
	public GetCityResponse getCity(@RequestPayload GetCityRequest request) {
		GetCityResponse response = new GetCityResponse();
		response.getCities().addAll(getCities());
		return response;
	}

	private List<String> getCities() {
		return List.of("Nouvoitou", "Chateaugiron", "Ossé");
	}
}