package com.example.hpjtrackerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class HpjTrackerBackendApplication {

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-5")); // Texas
	}
	public static void main(String[] args) {
		SpringApplication.run(HpjTrackerBackendApplication.class, args);
	}

}
