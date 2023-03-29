package com.example.vg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VgApplication {

	public static void main(String[] args) {
		SpringApplication.run(VgApplication.class, args);
	}

}
