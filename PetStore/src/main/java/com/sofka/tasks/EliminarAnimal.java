package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaCarrito.REMOVE_BUTTON;
import static com.sofka.ui.PaginaPerros.ADD_TO_CART_BUTTON;
import static com.sofka.ui.PaginaPerros.GOLDEN_RETRIEVER_ID;

public class EliminarAnimal implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(REMOVE_BUTTON)
        );
    }
    public static EliminarAnimal eliminarAnimal(){
        return new EliminarAnimal();
    }
}
