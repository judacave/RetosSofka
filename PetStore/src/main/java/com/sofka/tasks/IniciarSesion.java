package com.sofka.tasks;

import io.cucumber.java.sl.In;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaLogin.LOGINN_BUTTON;

public class IniciarSesion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGINN_BUTTON)
        );
    }
    public static IniciarSesion iniciarSesion(){
        return new IniciarSesion();
    }
}
