package com.example.hpjtrackerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class HpjTrackerBackendApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-5")); // Texas
		SpringApplication.run(HpjTrackerBackendApplication.class, args);
	}

}
