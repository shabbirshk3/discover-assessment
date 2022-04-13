package com.discover.delegate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.discover.clients.AccomodationClient;
import com.discover.model.client.AccomodationDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Component
public class AccomodationDelegate {
	
	@Value("${accomodation.host}")
	private String  accomodationHost;
	
	@Autowired
	private AccomodationClient accomodationClient;
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand
	public AccomodationDetails getPassengerAccomodationDetails(String passengerId) {
		return accomodationClient.getPassengerAccomodationDetails(passengerId);
	}

	public AccomodationDetails getPassengerAccomodationDetailsFallBack(String passengerId) {
		return null;
	}
	
	public AccomodationDetails getPassengerAccomodationDetailsUsingRestTemplate(String passengerId) {
		String url = accomodationHost+"/getaccomodationdetails"+"/"+"{passengerId}";
		Map<String,String> params = new HashMap<>();
		params.put("passengerId", passengerId);
		return restTemplate.getForObject(url, AccomodationDetails.class,params);
	}


}
