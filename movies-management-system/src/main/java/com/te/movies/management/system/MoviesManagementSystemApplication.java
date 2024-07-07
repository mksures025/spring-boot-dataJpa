package com.te.movies.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MoviesManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesManagementSystemApplication.class, args);
	}

}
