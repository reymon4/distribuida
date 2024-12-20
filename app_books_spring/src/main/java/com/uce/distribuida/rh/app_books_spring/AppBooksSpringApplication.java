package com.uce.distribuida.rh.app_books_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.uce.distribuida.rh.app_books_spring.clients")
public class AppBooksSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppBooksSpringApplication.class, args);
    }

}
