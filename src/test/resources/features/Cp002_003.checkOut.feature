Feature: Checkout con Cheque

  Background:
    Given Ingreso a la pagina web AutomationPractice
    Given Doy clic en signIn me logueo con usuario y contrasena correctas
      | Usuario            | Password |
      | ronalggm@gmail.com | 123456   |
@Checkout
  Scenario: Checkout con Cheque
    When Escribo nombre de un producto "All"
    And Doy clic en el boton de busqueda
    #And Agrego un producto al carrito
    And Agrego los siguientes productos al carrito
      | Productos                   |
      | Printed Summer Dress        |
      | Faded Short Sleeve T-shirts |
      | Blouse                      |

    And Realizo el checkout con "Pay By check"
    Then Valido que la compra fue exitosa para "Cheque"

@Checkout
  Scenario: Checkout con Transferencia Bancaria
    When Escribo nombre de un producto "All"
    And Doy clic en el boton de busqueda
    #And Agrego un producto al carrito
    And Agrego los siguientes productos al carrito
      | Productos                   |
      | Printed Summer Dress        |
      | Faded Short Sleeve T-shirts |
      | Blouse                      |
    And Realizo el checkout con "Transferencia"
    Then Valido que la compra fue exitosa para "Transferencia"
