package com.rbiedrawa.app.steps;

import static org.assertj.core.api.Assertions.*;

import com.rbiedrawa.app.customers.CustomerRepository;

import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionalFeatureStepDefs {
	private final CustomerRepository customerRepository;

	@And("database is empty")
	public void databaseIsEmpty() {
		assertThat(customerRepository.count()).isZero();
	}
}
