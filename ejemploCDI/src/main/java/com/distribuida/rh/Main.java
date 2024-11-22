package com.distribuida.rh;

import com.distribuida.rh.service.StringService;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Main {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {


            StringService service = container.select(StringService.class).get();

            System.out.println(service.convert("hola mundo"));

        } catch (Exception e)

    {
        throw new RuntimeException(e);
    }
    }

}
