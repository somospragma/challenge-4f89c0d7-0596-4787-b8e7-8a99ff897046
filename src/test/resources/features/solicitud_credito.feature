Feature: Gestión de solicitudes de crédito

  Scenario: Registrar una solicitud de crédito
    Given una solicitud de crédito con número de operación "123456"
    When se registra la solicitud
    Then la solicitud debe estar en estado "PENDIENTE"