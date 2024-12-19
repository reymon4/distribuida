package com.uce.distribuida.rh.app_authors_spring;



import org.springframework.stereotype.Component;

@Component

public class AuthorsLifecycle {

//    @Value("${consul.host}")
//    private String consulIp;
//
//    @Value("${consul.port}")
//    private Integer consultPort;
//
//
//    private String serviceId;
//
//    private final Vertx vertx;
//
//    public AuthorsLifecycle(Vertx vertx) {
//        this.vertx = vertx;
//    }
//
//    @PostConstruct
//    public void init() throws Exception {
//        System.out.println("Iniciando servicio");
//        ConsulClient client = ConsulClient.create(vertx,
//                new ConsulClientOptions()
//                        .setHost(consulIp)
//                        .setPort(consultPort));
//
//        serviceId = UUID.randomUUID().toString();
//        var ipAddress = InetAddress.getLocalHost();
//
//        client.registerServiceAndAwait(new ServiceOptions()
//                .setName("app-authors")
//                .setId(serviceId)
//                .setAddress(ipAddress.getHostAddress())
//                .setPort(appPort));
//    }
//
//    @PreDestroy
//    public void stop() throws Exception {
//        System.out.println("Deteniendo servicio...");
//        ConsulClient client = ConsulClient.create(vertx,
//                new ConsulClientOptions()
//                        .setHost(consulIp)
//                        .setPort(consultPort));
//
//        client.deregisterServiceAndAwait(serviceId);
//    }
}