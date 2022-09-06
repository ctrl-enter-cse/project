package com.techtree.ttshoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableJpaRepositories("com.techtree.ttshoppingcart.repos")
@SpringBootApplication
@EnableScheduling
public class TtshoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtshoppingcartApplication.class, args);
	}

}
