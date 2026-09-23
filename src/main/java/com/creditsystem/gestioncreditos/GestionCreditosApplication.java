package com.creditsystem.gestioncreditos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;

import java.time.Duration;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties
public class GestionCreditosApplication {

    private final ApplicationProperties applicationProperties;

    public GestionCreditosApplication(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
        validateProperties();
    }

    private void validateProperties() {
        if (applicationProperties.getMotorRiesgoUrl() == null || applicationProperties.getMotorRiesgoUrl().isBlank()) {
            throw new IllegalStateException("La URL del motor de riesgo no puede estar vacía");
        }
        if (applicationProperties.getMaxRequestsPerSecond() <= 0) {
            throw new IllegalStateException("El número máximo de solicitudes por segundo debe ser positivo");
        }
        if (applicationProperties.getIdempotencyWindowHours() <= 0) {
            throw new IllegalStateException("La ventana de idempotencia debe ser positiva");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionCreditosApplication.class, args);
    }

    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(applicationProperties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(applicationProperties.getReadTimeout()))
                .build();
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags(
                "application", "gestion-creditos",
                "environment", applicationProperties.getEnvironment()
        );
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("\n==================================================");
            System.out.println("Sistema de Gestión de Créditos iniciado con éxito");
            System.out.println("Ambiente: " + applicationProperties.getEnvironment());
            System.out.println("Motor de Riesgo: " + applicationProperties.getMotorRiesgoUrl());
            System.out.println("Límite de solicitudes por segundo: " + applicationProperties.getMaxRequestsPerSecond());
            System.out.println("Ventana de idempotencia: " + applicationProperties.getIdempotencyWindowHours() + " horas");
            System.out.println("==================================================\n");
        };
    }
}

record ApplicationProperties(
        String motorRiesgoUrl,
        int maxRequestsPerSecond,
        int idempotencyWindowHours,
        String environment,
        long connectTimeout,
        long readTimeout) {}