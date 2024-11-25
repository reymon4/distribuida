package com.distribuida.rh.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class JPAConfig {
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("distribuida");
    }

    @Produces
    public EntityManagerFactory entityManagerFactory(){
        return entityManagerFactory;
    }
}
