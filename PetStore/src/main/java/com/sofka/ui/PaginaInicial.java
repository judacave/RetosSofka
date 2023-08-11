package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class PaginaInicial extends PageObject {

    public static final Target REPTILES_BUTTON = Target.the("Boton de Reptiles")
            .located(By.cssSelector("img[src='../images/reptiles_icon.gif']"));
    public static final Target PERROS_BUTTON = Target.the("Boton de Perros")
            .located(By.cssSelector("img[src='../images/dogs_icon.gif']"));
    public static final Target LOGIN_BUTTON = Target.the("Boton de Sign in")
            .located(By.xpath("//a[normalize-space()='Sign In']"));
}
