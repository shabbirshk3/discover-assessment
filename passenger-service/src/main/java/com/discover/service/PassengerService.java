package com.discover.service;

import java.util.List;

import com.discover.model.request.PassengerDetailsRequest;
import com.discover.model.response.PassengerDetailsResponse;

public interface PassengerService {
	
	public boolean addPassengerDetails(PassengerDetailsRequest passengerDetailsRequest);
	
	public PassengerDetailsResponse getPassengerDetails(String passengerId);

	public List<PassengerDetailsResponse> getAllPassengerDetails();

}
