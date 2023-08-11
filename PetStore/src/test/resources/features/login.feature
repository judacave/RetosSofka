Feature: Inicio de Sesión en la Tienda Virtual de Mascotas
  Yo como usuario de la tienda de mascotas
  Quiero loggearme para tener acceso a los distintos modulos

  Scenario: Iniciar sesión en el sistema
    Given que estoy en la pagina de inicio de sesion
    When ingreso mi nombre de usuario mi_usuario y contrasenna mi_clave
    And hago clic en el boton de inicio de sesion
    Then deberia ver la pagina de inicio de usuario