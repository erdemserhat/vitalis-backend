package com.vitalis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.vitalis.api"})
@ComponentScan({"com.vitalis.service"})
@EntityScan({"com.vitalis.data"})
@EnableJpaRepositories({"com.vitalis.data"})

public class VitalisApplication {
    private static final Logger logger = LoggerFactory.getLogger(VitalisApplication.class);

    public static void main(String[] args) {
        logger.info("VitalisApplication is starting...");
        SpringApplication.run(VitalisApplication.class, args);
        logger.info("[ O K ] VitalisApplication is running.... ");
    }

}
