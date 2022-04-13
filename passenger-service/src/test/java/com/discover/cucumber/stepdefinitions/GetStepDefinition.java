package com.discover.cucumber.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetStepDefinition {

	private String addURI;
	private HttpHeaders headers;
	private RestTemplate restTemplate;
	private ResponseEntity<String> response;
	private String responseBody;
	private String responseBodyPOST;
	

	@Given("^I set POST passenger service api endpoint$")
	public void setPostEndpoint() {
		addURI = "http://localhost:9090/addpassengerdetails";
		System.out.println("Add URL :" + addURI);
	}

	@When("^I set request header")
	public void setHeader() {
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content_Type", "application/json");
	}

	@And("^Send a POST HTTP request$")
	public void sendPostRequest() {
		String passengerJson = "{\"passengerId\": \"101\" ,\"passengerName\":\"johb\",\"passengerAge\": \"28\"}";
		System.out.println("\n\n" + passengerJson);
		HttpEntity<String> entity = new HttpEntity<String>(passengerJson, headers);
		restTemplate = new RestTemplate();
		response = restTemplate.postForEntity(addURI, entity, String.class);
	}

	@Then("^I receive valid response$")
	public void verifyPostResponse() {
		responseBodyPOST = response.getBody();
		responseBody = response.getBody().toString();
		System.out.println("responseBody --->" + responseBody);
		assertEquals(200, response.getStatusCodeValue());
	}

}
