package com.ESA.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepo, PasswordEncoder encoder) {

		User admin1 = new User();
		admin1.setFirstName("ESA_Staff");
		admin1.setLastName("Members");
		admin1.setUsername("ESA@gmail.com");
		admin1.setPassword(encoder.encode("1234567"));
		admin1.setRole(User.Role.ADMIN);

		return args ->  userRepo.save(admin1);

	}

	}
