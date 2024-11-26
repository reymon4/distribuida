package com.distribuida.rh;

import com.distribuida.rh.service.PersonaService;
import com.google.gson.GsonBuilder;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRoute;
import io.helidon.webserver.http.HttpRouting;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.inject.spi.CDI;

public class RestMain {

    static void handleHola(ServerRequest req, ServerResponse res) {
       var service=  CDI.current().select(PersonaService.class).get();
      var gson=  new GsonBuilder().setPrettyPrinting().create();
        var persona = service.getPersona(1);

        res.send(gson.toJson(persona));
    }

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        HttpRouting rt = HttpRouting.builder().
                get("/hola", (req, res) -> res.send("Hola mundo")).
                build();

        WebServer.builder().
                routing(it -> it
                        .get("/hola", RestMain::handleHola)
                ).
                port(8080).
                build().
                start();


    }
}
