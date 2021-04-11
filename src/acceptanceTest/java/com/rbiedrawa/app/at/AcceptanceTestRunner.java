package com.rbiedrawa.app.at;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.rbiedrawa.app.at"}, strict = true,
				 plugin = {"json:build/reports/cucumber/json-report/cucumber.json",
					 "usage:build/reports/cucumber/json-report/cucumber-usage.json",
					 "html:build/reports/cucumber/old-html-report"},
				 tags = "not @Disabled", features = {AcceptanceTestRunner.PATH + "hello.feature"})
public class AcceptanceTestRunner {

	static final String PATH = "src/acceptanceTest/resources/features/";

}