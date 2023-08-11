package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaCarrito {
    public static final Target PROCEED_CHECKOUT_BUTTON = Target.the("Boton para proceder al checkout")
            .located(By.xpath("//a[normalize-space()='Proceed to Checkout']"));

    public static final Target LOGIN_INTERFACE_MESSAGE = Target.the("Interfaz de login para asercion")
            .located(By.xpath("//p[normalize-space()='Please enter your username and password.']"));

    public static final Target REMOVE_BUTTON = Target.the("Boton para remover")
            .locatedBy("//a[text()='Remove']");
    public static final Target EMPTY_CART_MESSAGE = Target.the("Aviso de carrito vacio")
            .locatedBy("//b[text()='Your cart is empty.']");
}
