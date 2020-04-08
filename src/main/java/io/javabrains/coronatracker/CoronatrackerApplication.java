package io.javabrains.coronatracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //so spring knows the @scheduled methods are wrapped in a proxy and they need to be called
public class CoronatrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronatrackerApplication.class, args);
	}

}
