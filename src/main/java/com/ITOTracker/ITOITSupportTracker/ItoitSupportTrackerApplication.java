package com.ITOTracker.ITOITSupportTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication
public class ItoitSupportTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItoitSupportTrackerApplication.class, args);
	}

}
