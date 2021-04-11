package com.rbiedrawa.app.at.steps;

import com.rbiedrawa.app.at.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AcceptanceTest
public class SpringStepsDefs {

	@Before
	public void setup_cucumber_spring(Scenario scenario) {
		// Cucumber will recognize this class as glue and start spring context.
		log.info("===============================================");
		log.info("===============Acceptance Test=================");
		log.info("| Scenario: {} |", scenario.getId());
		log.info("===============================================");
	}

}
