package com.rbiedrawa.app.welcome;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/hello")
@AllArgsConstructor
public class WelcomeController {

	private final WelcomeService welcomeService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, String> greet(@RequestParam(defaultValue = "") String name) {
		return welcomeService.greet(name);
	}

}