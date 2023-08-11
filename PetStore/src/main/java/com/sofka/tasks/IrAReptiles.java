package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaInicial.REPTILES_BUTTON;

public class IrAReptiles implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(REPTILES_BUTTON)
        );
    }
    public static IrAReptiles irAReptiles(){
        return new IrAReptiles();
    }

}
