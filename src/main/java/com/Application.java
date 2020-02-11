package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
			System.out.println("Application demarree !");
		} catch (Exception e) {
			System.out.println("Application erreur  \n" + e);
		}
	}
}