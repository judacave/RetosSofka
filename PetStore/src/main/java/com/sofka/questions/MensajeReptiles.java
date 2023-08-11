package com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.PaginaReptiles.IGUANA;

public class MensajeReptiles implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return IGUANA.resolveFor(actor).getText();
    }
    public static MensajeReptiles mensajeReptiles(){
        return new MensajeReptiles();
    }
}
