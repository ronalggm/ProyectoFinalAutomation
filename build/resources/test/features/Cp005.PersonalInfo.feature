Feature: Cambiar datos personales de cuenta existente

  Background:
    Given Ingreso a la pagina web AutomationPractice
    And Doy clic en signIn me logueo con usuario y contrasena correctas
      | Usuario            | Password |
      | ronalggm@gmail.com | 123456   |
@PersonalInfo
  Scenario: Cambiar los datos de mi cuenta personal con datos correctos
    When Ingreso a mis datos personales
    And Modifico mis datos personales por los siguientes
      | Social title     | Mrs        |
      | First name       | Pedro      |
      | Last name        | Gutierrez  |
      | Date Birth       | 14/11/1993 |
      | Current Password | 123456     |
    Then Verifico que se visualice "Your personal information has been successfully updated."
    #Then Valido que los valores hayan sido modificados