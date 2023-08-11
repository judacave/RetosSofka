package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sofka.ui.PaginaLogin.*;
import static com.sofka.ui.PaginaPerros.ADD_TO_CART_BUTTON;
import static com.sofka.ui.PaginaPerros.GOLDEN_RETRIEVER_ID;

public class IngresarCredenciales implements Task{
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(USERNAME_INPUT),
                Enter.theValue(System.getenv("USER_PETSTORE")).into(USERNAME_INPUT),
                Enter.theValue(System.getenv("PASS_PETSTORE")).into(PASSWORD_INPUT)
        );
    }
    public static IngresarCredenciales ingresarCredenciales(){
        return new IngresarCredenciales();
    }
}
