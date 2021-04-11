package com.rbiedrawa.app.hello;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/hello")
@AllArgsConstructor
public class HelloController {

	private final HelloService helloService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<Map<String, String>> hello(@RequestParam(defaultValue = "World") String name) {
		return helloService.greet(name);
	}

}