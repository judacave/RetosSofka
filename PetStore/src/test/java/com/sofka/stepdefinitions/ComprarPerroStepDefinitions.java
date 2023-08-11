package com.sofka.stepdefinitions;

import com.sofka.setup.Setup;
import com.sofka.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofka.questions.MensajeLogin.mensajeLogin;
import static com.sofka.questions.MensajeReptiles.mensajeReptiles;
import static com.sofka.tasks.AgregarAlCarrito.agregarAlCarrito;
import static com.sofka.tasks.IrAPerros.irAPerros;
import static com.sofka.tasks.ProcederAPagar.procederAPagar;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ComprarPerroStepDefinitions extends Setup {

    public static Logger LOGGER = Logger.getLogger(ListarReptilesStepDefinitions.class);
    @Given("que estoy en la pagina de la tienda virtuaal de mascotas")
    public void queEstoyEnLaPaginaDeLaTiendaVirtuaalDeMascotas() {
        try {
            configurarNavegador();
            LOGGER.info("Inicio de la Automatizacion");
            theActorInTheSpotlight().wasAbleTo(new AbrirPaginaInicial());
        }catch (Exception e){
            handleException(e);
        }
    }
    @When("selecciono la categoria Perros")
    public void seleccionoLaCategoriaPerros() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    irAPerros()
            );
        }catch (Exception e){
            handleException(e);
        }
    }
    @When("selecciono y agrego el perro deseado al carrito")
    public void seleccionoYAgregoElPerroDeseadoAlCarrito() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    agregarAlCarrito()
            );
        }catch (Exception e){
            handleException(e);
        }
    }

    @When("procedo al proceso de pago")
    public void procedoAlProcesoDePago() {
        try {
            theActorInTheSpotlight().attemptsTo(procederAPagar());
        }catch (Exception e){
            handleException(e);
        }
    }

    @Then("deberia ver la confirmacion de compra exitosa")
    public void deberiaVerLaConfirmacionDeCompraExitosa() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(mensajeLogin(), equalTo("Please enter your username and password."))
            );
            Thread.sleep(5000);
            quitarDriver();
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
