package com.distribuida.rh;

import com.distribuida.rh.db.Persona;
import com.distribuida.rh.service.PersonaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRoute;
import io.helidon.webserver.http.HttpRouting;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

public class RestMain {

    static Gson gson=  new GsonBuilder().setPrettyPrinting().create();


    static void handleHola(ServerRequest req, ServerResponse res) {
       var service=  CDI.current().select(PersonaService.class).get();
        res.send(gson.toJson(service.getPersona(Integer.parseInt(req.path().pathParameters().get("id")))));
    }

    static void handlePersonas(ServerRequest req, ServerResponse res) {
        var service=  CDI.current().select(PersonaService.class).get();
        res.send(gson.toJson(service.getPersonas()));
    }

    static void handleAddPersona(ServerRequest req, ServerResponse res) {
        var service=  CDI.current().select(PersonaService.class).get();
        String jsonBody = req.content().as(String.class);
        Persona p= gson.fromJson(jsonBody, Persona.class);
        service.addPersona(p);
        res.send(gson.toJson(service.getPersonaByName(p.getNombre())));
    }

    static void handleUpdatePersona(ServerRequest req, ServerResponse res) {
        var service=  CDI.current().select(PersonaService.class).get();
        String jsonBody = req.content().as(String.class);
        Persona p= gson.fromJson(jsonBody, Persona.class);
        p.setId(Integer.parseInt(req.path().pathParameters().get("id")));
        service.updatePersona(p);
        res.send(gson.toJson(service.getPersona(p.getId())));
    }
    static void handleDeletePersona(ServerRequest req, ServerResponse res) {
        var service=  CDI.current().select(PersonaService.class).get();
        Integer id = Integer.parseInt(req.path().pathParameters().get("id"));
        service.deletePersona(id);
        res.send("Persona eliminada!");
    }


    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        HttpRouting rt = HttpRouting.builder().
                get("/hola", (req, res) -> res.send("Hola mundo")).
                build();

        WebServer.builder().
                routing(it -> it
                        .get("/personas/{id}", RestMain::handleHola)
                        .get("/personas", RestMain::handlePersonas)
                        .post("/personas", RestMain::handleAddPersona)
                        .put("/personas/{id}", RestMain::handleUpdatePersona)
                        .delete("/personas/{id}", RestMain::handleDeletePersona)
                ).
                port(8080).
                build().
                start();


    }
}
