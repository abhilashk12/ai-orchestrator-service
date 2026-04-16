package com.example.ai_orchestrator_service.controller;

import com.example.ai_orchestrator_service.clients.ProductClient;
import com.example.ai_orchestrator_service.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class HealthController {
    @Autowired
    ProductClient productClient;

    @Autowired
    AiService aiService;

    @GetMapping("/health")
    public String health() {
        return "AI Orchestrator is running";
    }

    @GetMapping("/test-products")
    public Mono<List<String>> test() {
        return productClient.searchProducts("iPhone");
    }
    @PostMapping("/ask")
    public String ask(@RequestBody String prompt) {
        return aiService.ask(prompt);
    }
}
