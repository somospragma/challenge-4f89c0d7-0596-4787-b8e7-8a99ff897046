package com.creditsystem.gestioncreditos.domain.ports;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import java.util.concurrent.CompletableFuture;

public interface MotorRiesgoService {
    CompletableFuture<EvaluacionRiesgo> evaluarRiesgo(SolicitudCredito solicitudCredito);
    
    record EvaluacionRiesgo(
            String resultado,
            String codigo,
            String descripcion) {
    }
}