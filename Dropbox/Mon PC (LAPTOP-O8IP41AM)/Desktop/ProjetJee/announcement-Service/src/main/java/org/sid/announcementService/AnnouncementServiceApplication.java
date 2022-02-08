package org.sid.announcementService;

import org.sid.announcementService.Repository.HouseRepository;
import org.sid.announcementService.ServiceImp.ImmobilierImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {ImmobilierImp.class, HouseRepository.class})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.sid.announcementService.feign")

public class AnnouncementServiceApplication {
    @LoadBalanced
    public static void main(String[] args) {
        SpringApplication.run(AnnouncementServiceApplication.class, args);
    }

}
