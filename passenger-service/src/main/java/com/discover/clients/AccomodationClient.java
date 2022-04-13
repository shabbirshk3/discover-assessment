package com.discover.clients;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.discover.model.client.AccomodationDetails;

@FeignClient(value = "accomodationClient", url = "${accomodation.host}")
public interface AccomodationClient {
	
	@RequestMapping("/getaccomodationdetails/{passengerId}")
	public AccomodationDetails getPassengerAccomodationDetails(@PathVariable("passengerId") String passengerId);

}
