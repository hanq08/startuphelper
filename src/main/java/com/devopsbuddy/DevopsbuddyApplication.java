package com.devopsbuddy;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.service.UserService;
import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.utils.UserUtils;

@SpringBootApplication

public class DevopsbuddyApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Value("${webmaster.username}")
	private String webmasterUsername;
	
	@Value("${webmaster.password}")
	private String webmasterPassword;
	
	@Value("${webmaster.email}")
	private String webmasterEmail;
	
	public static void main(String[] args) {
		SpringApplication.run(DevopsbuddyApplication.class, args);
	}
	
	@Override 
	public void run(String... args) throws Exception{
		String username = webmasterUsername;
		String email = webmasterEmail;
		User user = UserUtils.createBasicUser(username, email);
		user.setPassword(webmasterPassword);
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, new Role(RolesEnum.ADMIN)));
		userService.createUser(user, PlansEnum.PRO, userRoles);
	}
}
