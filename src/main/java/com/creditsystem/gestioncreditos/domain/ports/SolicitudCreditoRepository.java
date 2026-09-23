package com.creditsystem.gestioncreditos.domain.ports;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import java.util.Optional;
import java.util.UUID;

public interface SolicitudCreditoRepository {
    SolicitudCredito save(SolicitudCredito solicitudCredito);
    
    Optional<SolicitudCredito> findById(UUID id);
    
    Optional<SolicitudCredito> findByNumeroOperacionAndCanal(String numeroOperacion, String canal);
    
    Optional<SolicitudCredito> findByClaveIdempotencia(String claveIdempotencia);
}