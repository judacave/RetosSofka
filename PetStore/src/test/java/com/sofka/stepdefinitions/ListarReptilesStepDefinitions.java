package com.sofka.stepdefinitions;

import com.sofka.setup.Setup;
import com.sofka.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofka.questions.MensajeReptiles.mensajeReptiles;
import static com.sofka.tasks.IrAReptiles.irAReptiles;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ListarReptilesStepDefinitions extends Setup {

    public static Logger LOGGER = Logger.getLogger(ListarReptilesStepDefinitions.class);
    @Given("que estoy en la pagina de la tienda virtual de mascotas")
    public void queEstoyEnLaPaginaDeLaTiendaVirtualDeMascotas() {
        try {
            configurarNavegador();
            LOGGER.info("Inicio de la Automatizacion");
            theActorInTheSpotlight().wasAbleTo(new AbrirPaginaInicial());
        }catch (Exception e){
            handleException(e);
        }
    }

    @When("consulto las clases de reptiles")
    public void consultoLasClasesDeReptiles() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    irAReptiles()
            );
        }catch (Exception e){
            handleException(e);
        }
    }
    @Then("deberia ver un listado con todos los reptiles")
    public void deberiaVerUnListadoConTodosLosReptiles() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(mensajeReptiles(), equalTo("Iguana"))
            );
        }catch (Exception e){
            handleException(e);
        }finally {
            quitarDriver();
        }
    }
    private void handleException(Exception e) {
        LOGGER.warn(e.getMessage());
        Assertions.fail();
        quitarDriver();
    }
}
