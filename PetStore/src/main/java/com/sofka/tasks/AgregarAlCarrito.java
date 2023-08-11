package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaInicial.PERROS_BUTTON;
import static com.sofka.ui.PaginaPerros.ADD_TO_CART_BUTTON;
import static com.sofka.ui.PaginaPerros.GOLDEN_RETRIEVER_ID;

public class AgregarAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GOLDEN_RETRIEVER_ID),
                Click.on(ADD_TO_CART_BUTTON)
        );
    }
    public static AgregarAlCarrito agregarAlCarrito(){
        return new AgregarAlCarrito();
    }

}
