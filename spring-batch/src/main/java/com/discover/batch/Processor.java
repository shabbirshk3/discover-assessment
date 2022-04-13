package com.discover.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.discover.model.entity.Passenger;

@Component
public class Processor implements ItemProcessor<Passenger, Passenger> {

	@Override
	public Passenger process(Passenger passenger) throws Exception {

		return passenger;
	}
}
