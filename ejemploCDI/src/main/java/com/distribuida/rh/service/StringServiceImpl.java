package com.distribuida.rh.service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

//Anotación que indica que la clase es un bean de CDI (un componente como en Spring)
@ApplicationScoped
public class StringServiceImpl implements  StringService{
    @Inject
    LogService log;


    /*@PostConstruct
    public void init(){
        log = CDI.current().select(LogService.class).get();
    }*/

    @Override
    public String convert(String txt) {
        log.log("Convirtiendo a mayúsculas: " + txt);
        return txt.toUpperCase();
    }

}
