package com.distribuida.rh;

import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRoute;
import io.helidon.webserver.http.HttpRouting;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class RestMain {

    static void handleHola(ServerRequest req, ServerResponse res) {
        res.send("Hola mundo");
    }

    public static void main(String[] args) {
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
