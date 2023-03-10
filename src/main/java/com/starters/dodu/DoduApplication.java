package com.starters.dodu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DoduApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoduApplication.class, args);
	}

}
