package com.rbiedrawa.app.at.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.rbiedrawa.app.at.dtos.ExpectedWelcomeMessage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@WebAppConfiguration
public class WelcomeFeatureStepDefs {

	@Autowired
	private WebTestClient webTestClient;

	private String customerName;
	private WebTestClient.ResponseSpec result;

	@When("customer visits home page")
	public void customerVisitsHomePage() {
		result = webTestClient.get()
							  .uri(uri -> uri.path("/api/hello")
											 .queryParam("name", customerName)
											 .build()).accept(MediaType.APPLICATION_JSON)
							  .exchange();
	}

	@Given("customer: (.*)$")
	public void customerTest(String customerName) {
		this.customerName = customerName;
	}

	@Then("customer should see the welcome message")
	public void customerShouldSeeTheWelcomeMessage(ExpectedWelcomeMessage expectedWelcomeMessage) {
		result.expectStatus().isOk()
			  .expectHeader().contentType(MediaType.APPLICATION_JSON)
			  .expectBody()
			  .jsonPath("$.message").isEqualTo(expectedWelcomeMessage.getMessage());

	}
}
