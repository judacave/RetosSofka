package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaInicial.PERROS_BUTTON;

public class IrAPerros implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PERROS_BUTTON)
        );
    }
    public static IrAPerros irAPerros(){
        return new IrAPerros();
    }
}
