package com.github.javastudytelegrambot.jstb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavaStudyTelegramBotApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaStudyTelegramBotApplication.class, args);
	}
}
