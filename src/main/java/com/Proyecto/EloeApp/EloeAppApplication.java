package com.Proyecto.EloeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*
security.basic.enable: false
security.ignored=/**
*/

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EloeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EloeAppApplication.class, args);
	}	
	
}

