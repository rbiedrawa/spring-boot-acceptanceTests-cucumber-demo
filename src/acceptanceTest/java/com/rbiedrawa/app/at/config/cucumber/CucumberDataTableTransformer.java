package com.rbiedrawa.app.at.config.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;

import java.lang.reflect.Type;

public class CucumberDataTableTransformer {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@DefaultParameterTransformer
	@DefaultDataTableEntryTransformer
	@DefaultDataTableCellTransformer
	public Object transformer(Object fromValue, Type toValueType) {
		return this.objectMapper.convertValue(fromValue, this.objectMapper.constructType(toValueType));
	}

}