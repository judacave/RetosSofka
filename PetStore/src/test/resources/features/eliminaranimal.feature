Feature: Eliminar un animal de una orden de compra en la Tienda Virtual de Mascotas
  Yo como usuario de la web JPetStore
  Quiero poder eliminar un animal de mi carrito de compras

  Scenario: Eliminar un animal de una orden de compra
    Given que estoy en la pagina de la tienda virtual de mascotas y tengo un animal en mi carrito
    When elimino ese animal de la orden de compra
    Then deberia ver la orden de compra sin el animal eliminado