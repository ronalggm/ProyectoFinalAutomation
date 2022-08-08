
Feature: Buscar uno o varios productos

  Background:
    Given Ingreso a la pagina web AutomationPractice
    And Doy clic en signIn me logueo con usuario y contrasena correctas
      | Usuario            | Password |
      | ronalggm@gmail.com | 123456   |
  @Search
  Scenario Outline: Buscar uno o varios productos

    When Escribo nombre de un producto <Producto>
    And Doy clic en el boton de busqueda
    Then Valido que aparezca <Cantidad> de elementos encontrado
    And Valido que aparezca el nombre <Nombre> en la pag

    Examples:
      | Producto  | Cantidad | Nombre    |
      | "blouse"  | 1        | "BLOUSE"  |
      | "all"     | 7        | "ALL"     |
      | "printed" | 5        | "PRINTED" |
      | "asdasd"  | 0        | ""        |

