package com.java.laurkan.interviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InterviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewerApplication.class, args);
	}

}
