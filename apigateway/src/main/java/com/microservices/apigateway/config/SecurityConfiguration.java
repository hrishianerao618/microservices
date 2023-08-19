package com.microservices.apigateway.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.ReactiveAuthenticationManagerResolver;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.ServerWebExchange;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity serverHttpSecurity){
            return serverHttpSecurity.csrf(csrfSpec -> csrfSpec.disable())
                    .authorizeExchange(authorizeExchangeSpec  -> authorizeExchangeSpec.pathMatchers("/eureka/**")
                            .permitAll()
                            .anyExchange()
                            .authenticated())
                    .oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec.jwt(jwtSpec -> jwtSpec.jwkSetUri("https://dev-rimifw0nqv2suafy.us.auth0.com/.well-known/jwks.json")))
                    .build()
                    ;
    }
}
