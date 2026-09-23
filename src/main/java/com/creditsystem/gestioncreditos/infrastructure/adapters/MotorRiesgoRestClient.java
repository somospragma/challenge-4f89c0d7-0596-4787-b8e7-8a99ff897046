package com.creditsystem.gestioncreditos.infrastructure.adapters;


import com.creditsystem.gestioncreditos.domain.ports.EvaluacionRiesgo;
import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;

@Service
public class MotorRiesgoRestClient implements MotorRiesgoService {

    private final RestTemplate restTemplate;
    private final String motorRiesgoUrl;

    public MotorRiesgoRestClient(RestTemplate restTemplate, @Value("${motor-riesgo.url}") String motorRiesgoUrl) {
        this.restTemplate = restTemplate;
        this.motorRiesgoUrl = motorRiesgoUrl;
    }

    @Override
    public CompletableFuture<MotorRiesgoService.EvaluacionRiesgo> evaluarRiesgo(SolicitudCredito solicitudCredito) {
        return CompletableFuture.supplyAsync(() -> {
            // Simula la llamada al servicio de riesgo externo
            return new MotorRiesgoService.EvaluacionRiesgo("Aprobado", "001", "Riesgo bajo");
        });
    }
}