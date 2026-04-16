package com.example.ai_orchestrator_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AiOrchestratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiOrchestratorServiceApplication.class, args);
	}

}
