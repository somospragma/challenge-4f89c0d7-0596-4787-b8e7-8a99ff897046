package com.creditsystem.gestioncreditos.bdd.steps;

import com.creditsystem.gestioncreditos.domain.models.SolicitudCredito;
import com.creditsystem.gestioncreditos.domain.ports.SolicitudCreditoRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolicitudCreditoSteps {

    @Autowired
    private SolicitudCreditoRepository solicitudCreditoRepository;

    private SolicitudCredito solicitudCredito;

    @Given("una solicitud de crédito con número de operación {string}")
    public void unaSolicitudDeCreditoConNumeroDeOperacion(String numeroOperacion) {
        solicitudCredito = new SolicitudCredito(numeroOperacion);
    }

    @When("se registra la solicitud")
    public void seRegistraLaSolicitud() {
        solicitudCreditoRepository.save(solicitudCredito);
    }

    @Then("la solicitud debe estar en estado {string}")
    public void laSolicitudDebeEstarEnEstado(String estado) {
        assertEquals(estado, solicitudCredito.getEstado());
    }
}