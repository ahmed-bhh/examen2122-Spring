package com.apex.clinique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy

public class CliniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliniqueApplication.class, args);
	}

}
