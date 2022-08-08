Feature: Contactenos

  Background:
    Given Ingreso a la pagina web AutomationPractice
@ContactUs
  Scenario: Completar formulario de Contactenos
    And Doy clic en contactenos
    When Completo los siguientes campos
      | Email address      | Order reference | Message                    |
      | ronalggm@gmail.com | 24335           | El producto tiene defectos |
    And Doy Clic en el boton Send
    Then Valido que el mensaje haya sido enviado exitosamente
