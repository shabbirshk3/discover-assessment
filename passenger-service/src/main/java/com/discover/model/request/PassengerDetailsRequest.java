package com.discover.model.request;

import javax.validation.constraints.NotBlank;

public class PassengerDetailsRequest {

	@NotBlank(message = "Id is mandatory")
	private String passengerId;
	@NotBlank(message = "Name is mandatory")
	private String passengerName;
	private String passengerAge;
	
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}
	

	

}
