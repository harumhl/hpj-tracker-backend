package com.example.hpjtrackerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class HpjTrackerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HpjTrackerBackendApplication.class, args);
	}
}
