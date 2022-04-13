package com.discover.data.helper;

import java.util.Optional;

import com.discover.model.client.AccomodationDetails;
import com.discover.model.entity.Passenger;
import com.discover.model.request.PassengerDetailsRequest;
import com.discover.model.response.PassengerDetailsResponse;

public class PassengerDataHelper {
	
	
	public static Optional<Passenger> getPassengerDetails() {
		
		Passenger passenger = new Passenger();
		passenger.setPassengerId("101");
		passenger.setPassengerName("shabbir");
		passenger.setPassengerAge("28");
		
		return Optional.of(passenger);
	}
	
	public static PassengerDetailsResponse getPassengerDetailsResponse() {
		
		PassengerDetailsResponse passenger = new PassengerDetailsResponse();
		passenger.setPassengerId("101");
		passenger.setPassengerName("shabbir");
		passenger.setPassengerAge("28");
		passenger.setCabinCategory("suite");
		passenger.setCabinNumber("A301");
		passenger.setDeckNumber("4");
		return passenger;
	}
	
public static PassengerDetailsRequest getPassengerDetailsRequest() {
		
	PassengerDetailsRequest passenger = new PassengerDetailsRequest();
		passenger.setPassengerId("101");
		passenger.setPassengerName("shabbir");
		passenger.setPassengerAge("28");
		return passenger;
	}

public static AccomodationDetails getAccomodationDetails() {
	AccomodationDetails accomodationDetails = new AccomodationDetails();
	accomodationDetails.setPassengerId("101");
	accomodationDetails.setCabinNumber("A301");
	accomodationDetails.setCabinCategory("suite");
	accomodationDetails.setDeckNumber("4");
	return accomodationDetails;
}

}
