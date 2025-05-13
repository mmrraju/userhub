package com.fusionpulse.userhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UserHubApplication {

	public static void main(String[] args) {
		// SpringApplication.run(UserHubApplication.class, args);
	
		Environment env = SpringApplication.run(UserHubApplication.class, args).getEnvironment();
        String port = env.getProperty("server.port");
        System.out.println("✅ Application is running on port: " + port);
		

		System.out.println("Hey, Server is running...");
	}

}
