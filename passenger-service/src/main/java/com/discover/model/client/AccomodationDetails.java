package com.discover.model.client;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccomodationDetails {
	@Id
	private String passengerId;
	private String cabinNumber;
	private String deckNumber;
	private String cabinCategory;
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getCabinNumber() {
		return cabinNumber;
	}
	public void setCabinNumber(String cabinNumber) {
		this.cabinNumber = cabinNumber;
	}
	public String getDeckNumber() {
		return deckNumber;
	}
	public void setDeckNumber(String deckNumber) {
		this.deckNumber = deckNumber;
	}
	public String getCabinCategory() {
		return cabinCategory;
	}
	public void setCabinCategory(String cabinCategory) {
		this.cabinCategory = cabinCategory;
	}
	

	
	

}
