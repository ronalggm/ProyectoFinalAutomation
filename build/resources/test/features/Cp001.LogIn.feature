Feature: Iniciar sesion

 Background:

   Given Ingreso a la pagina web AutomationPractice

   Given Doy clic en signIn me logueo con usuario y contrasena correctas
     | Usuario            | Password |
     | ronalggm@gmail.com | 123456   |

@Login
  Scenario: Iniciar sesion con usuario y contraseña correctos

    Then verifico que este logueado


