package com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.PaginaCarrito.LOGIN_INTERFACE_MESSAGE;
import static com.sofka.ui.PaginaReptiles.IGUANA;

public class MensajeLogin implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LOGIN_INTERFACE_MESSAGE.resolveFor(actor).getText();
    }
    public static MensajeLogin mensajeLogin(){
        return new MensajeLogin();
    }
}
