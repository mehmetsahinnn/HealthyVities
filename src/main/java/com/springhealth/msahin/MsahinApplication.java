package com.springhealth.msahin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication() //exclude = {SecurityAutoConfiguration.class}
public class MsahinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsahinApplication.class, args);
	}

}
