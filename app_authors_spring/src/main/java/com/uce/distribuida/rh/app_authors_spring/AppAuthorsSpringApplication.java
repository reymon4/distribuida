package com.uce.distribuida.rh.app_authors_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class AppAuthorsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppAuthorsSpringApplication.class, args);
    }

}
