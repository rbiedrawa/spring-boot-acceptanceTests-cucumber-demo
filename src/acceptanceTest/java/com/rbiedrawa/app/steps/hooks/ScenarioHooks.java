package com.rbiedrawa.app.steps.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScenarioHooks {

	@Before
	public void printCurrentScenario(Scenario scenario) {
		log.info("===============================================");
		log.info("===============Acceptance Test=================");
		log.info("| Scenario: {} |", scenario.getId());
		log.info("===============================================");
	}

}
