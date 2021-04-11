package com.rbiedrawa.app.steps;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.rbiedrawa.app.dtos.ExpectedWelcomeMessage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WelcomeFeatureStepDefs {
	private final MockMvc mockMvc;

	private String customerName;
	private ResultActions result;

	@Given("customer: (.*)$")
	public void setName(String customerName) {
		this.customerName = customerName;
	}

	@When("customer visits home page")
	public void customerVisitsHomePage() throws Exception {
		result = mockMvc.perform(get("/api/hello")
									 .param("name", customerName)
									 .accept(MediaType.APPLICATION_JSON))
						.andDo(print());
	}

	@Then("customer should see the welcome message")
	public void customerShouldSeeTheWelcomeMessage(ExpectedWelcomeMessage expectedWelcomeMessage) throws Exception {
		result.andExpect(status().isOk())
			  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
			  .andExpect(jsonPath("$.message").value(expectedWelcomeMessage.getMessage()));
	}
}
