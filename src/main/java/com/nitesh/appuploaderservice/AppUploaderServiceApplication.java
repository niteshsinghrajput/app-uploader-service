package com.nitesh.appuploaderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AppUploaderServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(AppUploaderServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AppUploaderServiceApplication.class, args);
        log.info("${jndi:ldap://127.0.0.1:8080/a");
    }
}
