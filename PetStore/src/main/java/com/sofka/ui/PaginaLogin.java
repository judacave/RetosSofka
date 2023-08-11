package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLogin {
    public static final Target USERNAME_INPUT = Target.the("Input para el username")
            .locatedBy("//input[@name='username']");
    public static final Target PASSWORD_INPUT = Target.the("Input para la password")
            .located(By.cssSelector("input[value='j2ee']"));
    public static final Target LOGINN_BUTTON = Target.the("Boton para iniciar sesion")
            .locatedBy("//input[@name='signon']");
}
