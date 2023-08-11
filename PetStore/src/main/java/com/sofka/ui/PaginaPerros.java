package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPerros {
    public static final Target GOLDEN_RETRIEVER_ID = Target.the("Id de Golden Retriever")
            .located(By.cssSelector("a[href='/actions/Catalog.action?viewProduct=&productId=K9-RT-01']"));
    public static final Target ADD_TO_CART_BUTTON = Target.the("Boton agregar al carrito")
            .located(By.cssSelector(".Button"));
}
