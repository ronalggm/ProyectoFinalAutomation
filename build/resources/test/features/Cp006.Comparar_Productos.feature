Feature: Comparar Productos

  Background:
    Given Ingreso a la pagina web AutomationPractice

  @Comparar
  Scenario: Comparar dos productos
    When Busco algunos productos y los agrego para comparar

    Then Verifico que la cantidad coincide correctamente
    And Doy clic en el boton compare
    Then Verifico que se comparen correctamente
