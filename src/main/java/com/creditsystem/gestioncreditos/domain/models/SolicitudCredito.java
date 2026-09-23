package com.creditsystem.gestioncreditos.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record SolicitudCredito(
        UUID id,
        String numeroOperacion,
        String canal,
        String tipoDocumento,
        String numeroDocumento,
        String nombreSolicitante,
        String apellidoSolicitante,
        BigDecimal montoSolicitado,
        Integer plazoMeses,
        BigDecimal tasaInteres,
        String estado,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion,
        String resultadoRiesgo,
        String codigoRiesgo,
        String descripcionRiesgo) {

    public static final String ESTADO_PENDIENTE = "PENDIENTE";
    public static final String ESTADO_APROBADO = "APROBADO";
    public static final String ESTADO_RECHAZADO = "RECHAZADO";
    public static final String ESTADO_ERROR = "ERROR";

    public SolicitudCredito {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la solicitud no puede ser nulo");
        }
        if (numeroOperacion == null || numeroOperacion.isBlank()) {
            throw new IllegalArgumentException("El número de operación no puede ser nulo o vacío");
        }
        if (canal == null || canal.isBlank()) {
            throw new IllegalArgumentException("El canal no puede ser nulo o vacío");
        }
        if (montoSolicitado == null || montoSolicitado.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto solicitado debe ser mayor que cero");
        }
        if (plazoMeses == null || plazoMeses <= 0) {
            throw new IllegalArgumentException("El plazo en meses debe ser mayor que cero");
        }
        if (tasaInteres == null || tasaInteres.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser mayor que cero");
        }
        if (estado == null || estado.isBlank()) {
            estado = ESTADO_PENDIENTE;
        }
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
        if (fechaActualizacion == null) {
            fechaActualizacion = LocalDateTime.now();
        }
    }

    public SolicitudCredito conResultadoRiesgo(String resultadoRiesgo, String codigoRiesgo, String descripcionRiesgo) {
        return new SolicitudCredito(
                this.id,
                this.numeroOperacion,
                this.canal,
                this.tipoDocumento,
                this.numeroDocumento,
                this.nombreSolicitante,
                this.apellidoSolicitante,
                this.montoSolicitado,
                this.plazoMeses,
                this.tasaInteres,
                resultadoRiesgo.equals("APROBADO") ? ESTADO_APROBADO : ESTADO_RECHAZADO,
                this.fechaCreacion,
                LocalDateTime.now(),
                resultadoRiesgo,
                codigoRiesgo,
                descripcionRiesgo
        );
    }

    public SolicitudCredito conEstado(String nuevoEstado) {
        return new SolicitudCredito(
                this.id,
                this.numeroOperacion,
                this.canal,
                this.tipoDocumento,
                this.numeroDocumento,
                this.nombreSolicitante,
                this.apellidoSolicitante,
                this.montoSolicitado,
                this.plazoMeses,
                this.tasaInteres,
                nuevoEstado,
                this.fechaCreacion,
                LocalDateTime.now(),
                this.resultadoRiesgo,
                this.codigoRiesgo,
                this.descripcionRiesgo
        );
    }

    public String generarClaveIdempotencia() {
        return numeroOperacion + "|" + canal;
    }
}