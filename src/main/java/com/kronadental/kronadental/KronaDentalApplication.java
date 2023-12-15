package com.kronadental.kronadental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KronaDentalApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(KronaDentalApplication.class);
        application.setAdditionalProfiles("default");
        application.run(args);
    }

}
