package com.distribuida.rh.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LogServiceImpl implements LogService {

    @Override
    public void log(String txt) {
        System.out.println("LOG: " + txt);
    }
}
