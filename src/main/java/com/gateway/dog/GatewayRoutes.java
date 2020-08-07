package com.gateway.dog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GatewayRoutes {

    @Value("${server.dog.api}")
    private String dogApiServer;

    @Value("${dog.api.path}")
    private String dogApiPath; 
    
    private static final String FORMAT = "%s/**";
    
    @Bean
    public RouteLocator buildRoutes(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path(String.format(FORMAT, dogApiPath)).uri(dogApiServer)).build();
    }
}
