package com.creditsystem.gestioncreditos.infrastructure.controllers;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.infrastructure.adapters.SolicitudCreditoJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoControllerTest {

    @Mock
    private SolicitudCreditoJpaRepository solicitudCreditoJpaRepository;

    @InjectMocks
    private SolicitudCreditoController solicitudCreditoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrarSolicitudCredito() {
        // Arrange
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        when(solicitudCreditoJpaRepository.save(any(SolicitudCredito.class))).thenReturn(solicitudCredito);

        // Act
        SolicitudCredito result = solicitudCreditoController.registrarSolicitudCredito(solicitudCredito);

        // Assert
        assertNotNull(result);
        verify(solicitudCreditoJpaRepository, times(1)).save(any(SolicitudCredito.class));
    }
}