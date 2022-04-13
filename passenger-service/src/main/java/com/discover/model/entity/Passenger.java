package com.discover.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Passenger {
	@Id
	private String passengerId;
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
