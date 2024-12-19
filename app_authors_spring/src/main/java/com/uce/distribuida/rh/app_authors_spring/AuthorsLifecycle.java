package com.uce.distribuida.rh.app_authors_spring;


import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.consul.ConsulClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.net.InetAddress;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.util.UUID;

@Component
public class AuthorsLifecycle {

    @Value("${consul.host:127.0.0.1}")
    private String consulIp;

    @Value("${consul.port:8500}")
    private Integer consultPort;

    @Value("${server.port}")
    private Integer appPort;

    private String serviceId;

    private final Vertx vertx;

    public AuthorsLifecycle(Vertx vertx) {
        this.vertx = vertx;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Iniciando servicio");
        ConsulClient client = ConsulClient.create(vertx,
                new ConsulClientOptions()
                        .setHost(consulIp)
                        .setPort(consultPort));

        serviceId = UUID.randomUUID().toString();
        var ipAddress = InetAddress.getLocalHost();

        client.registerServiceAndAwait(new ServiceOptions()
                .setName("app-authors")
                .setId(serviceId)
                .setAddress(ipAddress.getHostAddress())
                .setPort(appPort));
    }

    @PreDestroy
    public void stop() throws Exception {
        System.out.println("Deteniendo servicio...");
        ConsulClient client = ConsulClient.create(vertx,
                new ConsulClientOptions()
                        .setHost(consulIp)
                        .setPort(consultPort));

        client.deregisterServiceAndAwait(serviceId);
    }
}