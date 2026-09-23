package com.creditsystem.gestioncreditos.application.usecases;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import com.creditsystem.gestioncreditos.domain.ports.MotorRiesgoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrarSolicitudCreditoUseCaseTest {

    @Mock
    private SolicitudCreditoRepository solicitudCreditoRepository;

    @Mock
    private MotorRiesgoService motorRiesgoService;

    @InjectMocks
    private RegistrarSolicitudCreditoUseCase registrarSolicitudCreditoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrarSolicitudCredito() {
        // Arrange
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        when(solicitudCreditoRepository.save(any(SolicitudCredito.class))).thenReturn(solicitudCredito);

        // Act
        SolicitudCredito result = registrarSolicitudCreditoUseCase.registrarSolicitudCredito(solicitudCredito);

        // Assert
        assertNotNull(result);
        verify(solicitudCreditoRepository, times(1)).save(any(SolicitudCredito.class));
    }
}