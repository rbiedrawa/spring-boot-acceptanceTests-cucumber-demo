package com.rbiedrawa.app.at;

import org.junit.jupiter.api.Tag;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.rbiedrawa.app.Application;
import com.rbiedrawa.app.at.config.Profiles;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(Profiles.ACCEPTANCE_TEST)
@Tag(Profiles.ACCEPTANCE_TEST)
@AutoConfigureWireMock(port = AcceptanceTest.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public @interface AcceptanceTest {

	int RANDOM_PORT = 0;

}
