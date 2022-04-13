package com.discover.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.discover.exception.NotFoundException;
import com.discover.model.request.PassengerDetailsRequest;
import com.discover.model.response.PassengerDetailsResponse;
import com.discover.service.PassengerService;

@RestController
@CrossOrigin
@RequestMapping("/passenger-service")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@PostMapping("/addpassengerdetails")
	public boolean addPassengerDetails(@RequestBody @Valid PassengerDetailsRequest passengerDetailsRequest) {
		
		return passengerService.addPassengerDetails(passengerDetailsRequest);
	}

	@GetMapping("/getpassengerdetails")
	public ResponseEntity<PassengerDetailsResponse> getPassengerDetails(@RequestParam String passengerId) {
		PassengerDetailsResponse passenger = null;
		try {
			passenger = passengerService.getPassengerDetails(passengerId);
		} catch (NotFoundException exception) {
			return new ResponseEntity<>(passenger, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(passenger, HttpStatus.OK);
	}
	
	@GetMapping("/getallpassengerdetails")
	public ResponseEntity<List<PassengerDetailsResponse>> getAllPassengerDetails() {
		List<PassengerDetailsResponse> passengers = null;
		passengers = passengerService.getAllPassengerDetails();
		
		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

}
