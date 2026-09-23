package com.creditsystem.gestioncreditos.infrastructure.controllers;


import com.creditsystem.gestioncreditos.domain.ports.EvaluacionRiesgo;
import com.creditsystem.gestioncreditos.application.usecases.RegistrarSolicitudCreditoUseCase;
import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/creditos")
public class SolicitudCreditoController {

    private final RegistrarSolicitudCreditoUseCase registrarSolicitudCreditoUseCase;
    private final MotorRiesgoService motorRiesgoService;

    @Autowired
    public SolicitudCreditoController(RegistrarSolicitudCreditoUseCase registrarSolicitudCreditoUseCase, MotorRiesgoService motorRiesgoService) {
        this.registrarSolicitudCreditoUseCase = registrarSolicitudCreditoUseCase;
        this.motorRiesgoService = motorRiesgoService;
    }

    @PostMapping
    public ResponseEntity<SolicitudCredito> registrarSolicitud(@Valid @RequestBody SolicitudCredito solicitudCredito) {
        Mono<SolicitudCredito> solicitudRegistrada = registrarSolicitudCreditoUseCase.registrarSolicitud(solicitudCredito);
        solicitudRegistrada.subscribe(s -> solicitudCredito.conEstado(SolicitudCredito.ESTADO_PENDIENTE));
        Mono<MotorRiesgoService.EvaluacionRiesgo> evaluacionRiesgo = motorRiesgoService.evaluarRiesgo(solicitudCredito);
        evaluacionRiesgo.subscribe(e -> solicitudCredito.conResultadoRiesgo(e.resultadoRiesgo(), e.codigoRiesgo(), e.descripcionRiesgo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudCredito);
    }
}