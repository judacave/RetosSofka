package com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.InterfazUsuarioLoggeado.MY_ACCOUNT;
import static com.sofka.ui.PaginaCarrito.LOGIN_INTERFACE_MESSAGE;

public class ComprobacionLogin implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return MY_ACCOUNT.resolveFor(actor).getText();
    }
    public static ComprobacionLogin comprobacionLogin(){
        return new ComprobacionLogin();
    }
}
