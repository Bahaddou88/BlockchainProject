package com.example.demo;

import com.example.controller.ImmobilierController;
import com.example.metiers.ImmobilierMetier;
import com.example.metiers.ImmobilierMetierImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.example.models")
@ComponentScan(basePackageClasses = {ImmobilierMetierImpl.class, ImmobilierController.class, ImmobilierMetier.class})
@ComponentScan("com.example")
@SpringBootApplication
@EnableDiscoveryClient
public class ContractServiceApplication {
    public ContractServiceApplication() throws Exception {
    }

    @LoadBalanced
    public static void main(String[] args) {
        SpringApplication.run(ContractServiceApplication.class, args);
    }


}
