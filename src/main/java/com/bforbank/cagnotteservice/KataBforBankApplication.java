package com.bforbank.cagnotteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bforbank.cagnotteservice.repository")
@EntityScan(basePackages = "com.bforbank.cagnotteservice.entity")
public class KataBforBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataBforBankApplication.class, args);
    }

}

