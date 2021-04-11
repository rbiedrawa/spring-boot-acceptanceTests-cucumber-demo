package com.rbiedrawa.app.config.cucumber;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

import com.rbiedrawa.app.Application;
import com.rbiedrawa.app.config.profiles.Profiles;

import io.cucumber.spring.CucumberContextConfiguration;

@ActiveProfiles(Profiles.ACCEPTANCE_TEST)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = CucumberTestConfiguration.RANDOM_PORT)
public class CucumberTestConfiguration {
	public static final int RANDOM_PORT = 0;
}
