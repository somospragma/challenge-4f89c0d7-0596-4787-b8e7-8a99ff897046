package com.creditsystem.gestioncreditos.infrastructure.adapters;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SolicitudCreditoJpaRepository extends JpaRepository<SolicitudCredito, UUID>, SolicitudCreditoRepository {
    Optional<SolicitudCredito> findByNumeroOperacionAndCanal(String numeroOperacion, String canal);
    Optional<SolicitudCredito> findByClaveIdempotencia(String claveIdempotencia);
}