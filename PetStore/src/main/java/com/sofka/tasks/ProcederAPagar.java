package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaCarrito.PROCEED_CHECKOUT_BUTTON;
import static com.sofka.ui.PaginaInicial.REPTILES_BUTTON;

public class ProcederAPagar implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PROCEED_CHECKOUT_BUTTON)
        );
    }
    public static ProcederAPagar procederAPagar(){
        return new ProcederAPagar();
    }
}
