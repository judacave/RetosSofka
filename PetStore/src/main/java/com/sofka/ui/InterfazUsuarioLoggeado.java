package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InterfazUsuarioLoggeado {
    public static final Target MY_ACCOUNT = Target.the("My account")
            .locatedBy("//*[text()='My Account']");
}
