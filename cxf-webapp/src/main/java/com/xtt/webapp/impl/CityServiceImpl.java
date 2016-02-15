package com.xtt.webapp.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.xtt.webapp.CityService;
import com.xtt.webapp.exception.ZipCodeNotFoundException;
import com.xtt.webapp.zipcodes.Urlset;
import com.xtt.webapp.zipcodes.Ville;

@Controller
public class CityServiceImpl implements CityService {

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * public void setRestTemplate(RestTemplate restTemplate) {
	 * this.restTemplate = restTemplate; }
	 */

	@Override
	public List<String> getCitiesByZipCode(String zipCode)
			throws ZipCodeNotFoundException {
		try {
			Integer.parseInt(zipCode);
		} catch (NumberFormatException e) {
			throw new ZipCodeNotFoundException(zipCode);
		}

		String remoteUrl = "http://www.citysearch-api.com/fr/xml/city?login=sii&apikey=so7576e2adc5a2f95bbd9e1ca239327fb1cf7a9934&cp={cp}";
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("cp", zipCode);

		Urlset results = restTemplate.getForObject(remoteUrl, Urlset.class,
				vars);
		List<String> villes = new ArrayList<String>();
		for (Ville ville : results.getVille()) {
			villes.add(ville.getName());
		}
		return villes;
	}
}
