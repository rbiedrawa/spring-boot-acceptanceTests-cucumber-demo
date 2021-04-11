package com.rbiedrawa.app.welcome;

import java.util.Map;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class WelcomeService {

	public Mono<Map<String, String>> greet(String userName) {
		return Mono.just(Map.of("message", String.format("Hello %s!", userName)));
	}
}
