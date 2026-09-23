package com.creditsystem.gestioncreditos.application.usecases;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.CompletableFuture;

@Service
public class RegistrarSolicitudCreditoUseCase {
    private final SolicitudCreditoRepository solicitudCreditoRepository;
    private final MotorRiesgoService motorRiesgoService;

    public RegistrarSolicitudCreditoUseCase(SolicitudCreditoRepository solicitudCreditoRepository, MotorRiesgoService motorRiesgoService) {
        this.solicitudCreditoRepository = solicitudCreditoRepository;
        this.motorRiesgoService = motorRiesgoService;
    }

    @Transactional
    public CompletableFuture<SolicitudCredito> registrar(SolicitudCredito solicitudCredito) {
        SolicitudCredito savedSolicitud = solicitudCreditoRepository.save(solicitudCredito);
        return motorRiesgoService.evaluarRiesgo(savedSolicitud).thenApply(evaluacionRiesgo -> {
            savedSolicitud.conResultadoRiesgo(evaluacionRiesgo.getEstadoRiesgo(), evaluacionRiesgo.getCodigoRiesgo(), evaluacionRiesgo.getDescripcionRiesgo());
            return solicitudCreditoRepository.save(savedSolicitud);
        });
    }
}