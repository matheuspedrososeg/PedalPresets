package com.maeda.webapp;

import com.maeda.webapp.dao.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO) {
		return runner -> {
		};
	}

	private String deleteUser(int i, UserDAO userDAO) {
		userDAO.deleteUserById(i);
		return "User deleted successfully!";
	}

	private String updateUser(int i, String nome, UserDAO userDAO) {
		userDAO.updateUser(nome, i);
		return "User updated successfully!";
	}

	private String createUser(String name, UserDAO userDAO) {
		userDAO.createUser(name);
		return "Created user successfully!";
	}

}
