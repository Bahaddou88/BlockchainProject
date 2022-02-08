package org.lsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthentificationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthentificationApplication.class, args);
	}

}
