package com.discover.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discover.delegate.AccomodationDelegate;
import com.discover.exception.NotFoundException;
import com.discover.model.client.AccomodationDetails;
import com.discover.model.entity.Passenger;
import com.discover.model.request.PassengerDetailsRequest;
import com.discover.model.response.PassengerDetailsResponse;
import com.discover.repository.PassengerRepository;
import com.discover.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private AccomodationDelegate accomodationDelegate;

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PassengerServiceImpl.class);

	@Override
	public boolean addPassengerDetails(PassengerDetailsRequest passengerDetailsRequest) {
		try {
			passengerRepository.save(constructPassengerDetails(passengerDetailsRequest));
			return true;
		} catch (Exception exception) {
			logger.debug("Exception while adding Passenger Details");
		}
		return false;
	}

	public Passenger constructPassengerDetails(PassengerDetailsRequest passengerDetailsRequest) {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(passengerDetailsRequest.getPassengerId());
		passenger.setPassengerName(passengerDetailsRequest.getPassengerName());
		passenger.setPassengerAge(passengerDetailsRequest.getPassengerAge());
		return passenger;
	}

	@Override
	public PassengerDetailsResponse getPassengerDetails(String passengerId) throws NotFoundException {
		PassengerDetailsResponse passengerDetailsResponse = new PassengerDetailsResponse();
		Passenger passenger = null;
		AccomodationDetails accomodationDetails = new AccomodationDetails();
		try {
			passenger = passengerRepository.findById(passengerId).get();
		} catch (Exception exception) {
			logger.debug("Passenger Details not found");
			throw new NotFoundException("Passenger Details Not Found");
		}
		try {

			accomodationDetails = accomodationDelegate.getPassengerAccomodationDetailsUsingRestTemplate(passengerId);

		} catch (Exception exception) {
			logger.debug("Exception while retreiving Passenger Accomodation details");

		}
		if (passenger != null) {
			passengerDetailsResponse.setPassengerId(passenger.getPassengerId());
			passengerDetailsResponse.setPassengerName(passenger.getPassengerName());
			passengerDetailsResponse.setPassengerAge(passenger.getPassengerAge());
		}
		if (accomodationDetails != null) {
			passengerDetailsResponse.setCabinNumber(accomodationDetails.getCabinNumber());
			passengerDetailsResponse.setCabinCategory(accomodationDetails.getCabinCategory());
			passengerDetailsResponse.setDeckNumber(accomodationDetails.getDeckNumber());
		}
		return passengerDetailsResponse;
	}

	@Override
	public List<PassengerDetailsResponse> getAllPassengerDetails() {
		List<Passenger> passengers = passengerRepository.findAll();
		List<PassengerDetailsResponse> pasengerDetailsResponses = new ArrayList<>();
		passengers.forEach(passenger -> {
			AccomodationDetails accomodationDetails = new AccomodationDetails();
			PassengerDetailsResponse passengerDetailsResponse = new PassengerDetailsResponse();
			try {
				accomodationDetails = accomodationDelegate.getPassengerAccomodationDetails(passenger.getPassengerId());

			} catch (Exception exception) {
				logger.debug("Exception while retreiving Passenger Accomodation details");

			}
			passengerDetailsResponse.setCabinCategory(accomodationDetails.getCabinCategory());
			passengerDetailsResponse.setCabinNumber(accomodationDetails.getCabinNumber());
			passengerDetailsResponse.setDeckNumber(accomodationDetails.getDeckNumber());
			passengerDetailsResponse.setPassengerId(passenger.getPassengerId());
			passengerDetailsResponse.setPassengerName(passenger.getPassengerName());
			passengerDetailsResponse.setPassengerAge(passenger.getPassengerAge());
			pasengerDetailsResponses.add(passengerDetailsResponse);

		});
		return pasengerDetailsResponses;
	}

}
