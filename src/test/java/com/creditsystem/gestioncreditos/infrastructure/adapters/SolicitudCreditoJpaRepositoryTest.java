package com.creditsystem.gestioncreditos.infrastructure.adapters;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolicitudCreditoJpaRepositoryTest {

    @Mock
    private SolicitudCreditoRepository solicitudCreditoRepository;

    @InjectMocks
    private SolicitudCreditoJpaRepository solicitudCreditoJpaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveSolicitudCredito() {
        // Arrange
        SolicitudCredito solicitudCredito = new SolicitudCredito();
        when(solicitudCreditoRepository.save(any(SolicitudCredito.class))).thenReturn(solicitudCredito);

        // Act
        SolicitudCredito result = solicitudCreditoJpaRepository.save(solicitudCredito);

        // Assert
        assertNotNull(result);
        verify(solicitudCreditoRepository, times(1)).save(any(SolicitudCredito.class));
    }
}