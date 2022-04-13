package com.discover.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.discover.data.helper.PassengerDataHelper;
import com.discover.delegate.AccomodationDelegate;
import com.discover.model.response.PassengerDetailsResponse;
import com.discover.repository.PassengerRepository;

public class PassengerServiceImplTest {
	
	@InjectMocks
	private PassengerServiceImpl passengerServiceImpl;
	
	@Mock
	private PassengerRepository passengerRepository;

	@Mock
	private AccomodationDelegate accomodationDelegate;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void addPassengerDetailsTest() {
		
		passengerServiceImpl.addPassengerDetails(PassengerDataHelper.getPassengerDetailsRequest());
	}
	
	@Test
	public void getPassengerDetailsTest() {
		
		when(passengerRepository.findById(any())).thenReturn(PassengerDataHelper.getPassengerDetails());
		when(accomodationDelegate.getPassengerAccomodationDetailsUsingRestTemplate(any())).thenReturn(PassengerDataHelper.getAccomodationDetails());
		PassengerDetailsResponse passenger = passengerServiceImpl.getPassengerDetails("101");
		assertEquals("shabbir", passenger.getPassengerName());
		assertEquals("A301", passenger.getCabinNumber());
		
	}

}
