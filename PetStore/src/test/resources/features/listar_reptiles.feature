Feature: Consulta de Clases de Reptiles en la Tienda Virtual de Mascotas

  Scenario: Consultar todas las clases de reptiles
    Given que estoy en la pagina de la tienda virtual de mascotas
    When consulto las clases de reptiles
    Then deberia ver un listado con todos los reptiles