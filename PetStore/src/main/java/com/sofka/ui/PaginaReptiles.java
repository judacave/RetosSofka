package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaReptiles {
    public static final Target IGUANA = Target.the("Boton de Reptiles")
            .located(By.xpath("//td[normalize-space()='Iguana']"));
}
