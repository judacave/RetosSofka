Feature: Comprar un perro en JPetStore
  Yo como usuario de la web JPetStore
  Quiero comprar un perro

  Scenario: Comprar un perro Golden Retriever
    Given que estoy en la pagina de la tienda virtuaal de mascotas
    When selecciono la categoria Perros
    And selecciono y agrego el perro deseado al carrito
    And procedo al proceso de pago
    Then deberia ver la confirmacion de compra exitosa