package com.example.ai_orchestrator_service.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public Mono<List<String>> searchProducts(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("product-service")
                        .path("/products")
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToFlux(String.class)
                .collectList();
    }
}
