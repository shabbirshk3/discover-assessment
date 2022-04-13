package com.discover.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.discover.model.entity.Passenger;
import com.discover.repository.PassengerRepository;

@Component
public class DBWriter implements ItemWriter<Passenger> {

	private PassengerRepository passengerRepository;

	@Autowired
	public DBWriter(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	@Override
	public void write(List<? extends Passenger> passengers) throws Exception {
		System.out.println("Data Saved for Passengers: " + passengers);
		passengerRepository.saveAll(passengers);
	}
}
