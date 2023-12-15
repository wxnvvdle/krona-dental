package com.kronadental.kronadental.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dmytro")
public class DmytroProfile {

    private static final Logger logger = LoggerFactory.getLogger(DmytroProfile.class);

    @PostConstruct
    void postConstruct() {
        logger.info("loaded DmytroProfile");
    }

}
