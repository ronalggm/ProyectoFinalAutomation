Feature: Wish List
  Background:
    Given Ingreso a la pagina web AutomationPractice
    And Doy clic en signIn me logueo con usuario y contrasena correctas
      | Usuario            | Password |
      | ronalggm@gmail.com | 123456   |
  @WishList
  Scenario: Agrego dos productos a la wish list
    When Escribo nombre de un producto "printed"
    And Doy clic en el boton de busqueda
    And Agrego dos productos a la Wish list

    Then Valido que los productos se hayan agregado correctamente
    And Valido que la cantidad sea la correcta (2 productos)
    And Valido que los nombres de los productos sean los correctos
      | Nombres              |
      | Printed Dress        |
      | Printed Summer Dress |