package com.example.Annonceservice;

import com.example.lsi.controller.ImmobilierController;
import com.example.lsi.entities.Immobilier;
import com.example.lsi.entities.Type;
import com.example.lsi.repository.ImmobilierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages={
		"com.example.lsi.controller",
		"com.example.lsi.repository",
		"com.example.lsi.metier"})

@EnableMongoRepositories(basePackageClasses = ImmobilierRepository.class)
@EnableDiscoveryClient

public class AnnonceServiceApplication implements CommandLineRunner {

	@Autowired
	ImmobilierController immobilierController;

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(AnnonceServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	immobilierController.AddImmobiliesr(new Immobilier("Tanger","url","tanger","Boukhalef","azetyuio",1, Type.APARTMENT));
	}

}
