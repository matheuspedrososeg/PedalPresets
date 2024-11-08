package com.maeda.webapp;

import com.maeda.webapp.dao.PresetDAO;
import com.maeda.webapp.dao.UserDAO;
import com.maeda.webapp.entity.Preset;
import com.maeda.webapp.impl.UserRoleImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PresetDAO presetDAO) {
		return runner -> {
//			createPreset("Overdrive tone",5,40,9,20,15,20,50,80,40,7, presetDAO);
			findPreset(presetDAO, "teste");
		};
	}

	private List<Preset> findPreset(PresetDAO presetDAO, String username) {
		List<Preset> list = presetDAO.findPresetByUserId(username);
		return list;
	}

	private void createPreset(String name, int ir_cab, int reverb, int preset, int mix, int fb, int time, int mod, int tone, int gain, int type,PresetDAO presetDAO) {
		presetDAO.createPreset(name, ir_cab, reverb, preset, mix, fb, time, mod, tone, gain, type);
	}

	private String createUser(String name, String password, boolean active, UserRoleImpl userRole) {
		userRole.createUserWithRole(name, password, active);
		return "USER CREATED";
	}

	private String deleteUser(int i, UserDAO userDAO) {
		userDAO.deleteUserById(i);
		return "User deleted successfully!";
	}

	private String updateUser(int i, String nome, UserDAO userDAO) {
		userDAO.updateUser(nome, i);
		return "User updated successfully!";
	}

}
