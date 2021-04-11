package com.rbiedrawa.app.welcome;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rbiedrawa.app.customers.Customer;
import com.rbiedrawa.app.customers.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class WelcomeService {
	private final CustomerRepository customerRepository;

	@Transactional
	public Map<String, String> greet(String userName) {
		var customer = customerRepository.save(new Customer(userName));
		log.info("Customer: {}", customer);
		return Map.of("message", String.format("Hello %s!", customer.getName()));
	}
}
