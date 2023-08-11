package com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.InterfazUsuarioLoggeado.MY_ACCOUNT;
import static com.sofka.ui.PaginaCarrito.EMPTY_CART_MESSAGE;

public class MensajeCarritoVacio implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return EMPTY_CART_MESSAGE.resolveFor(actor).getText();
    }
    public static MensajeCarritoVacio mensajeCarritoVacio(){
        return new MensajeCarritoVacio();
    }
}
