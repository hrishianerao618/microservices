package com.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("customer", r -> r
                        .path("/api/microservice/customer/**")
                        .uri("lb://customer"))
                .route("rental", r -> r
                        .path("/api/microservice/rental/**")
                        .uri("lb://rental"))
                .route("discoveryserver", r->r
                        .path("/eureka/web")
                        .filters(f->f.rewritePath("/eureka/web", "/"))
                        .uri("http://localhost:8761"))
                .route("discoveryserverstatic", r->r
                        .path("/eureka/**")
                        .uri("http://localhost:8761"))

                .build();
    }
}
