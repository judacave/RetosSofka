package com.sofka.stepdefinitions;

import com.sofka.setup.Setup;
import com.sofka.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofka.questions.MensajeCarritoVacio.mensajeCarritoVacio;
import static com.sofka.tasks.AgregarAlCarrito.agregarAlCarrito;
import static com.sofka.tasks.EliminarAnimal.eliminarAnimal;
import static com.sofka.tasks.IrAPerros.irAPerros;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class EliminarAnimalStepDefinitions extends Setup {

    public static Logger LOGGER = Logger.getLogger(ListarReptilesStepDefinitions.class);
    @Given("que estoy en la pagina de la tienda virtual de mascotas y tengo un animal en mi carrito")
    public void queEstoyEnLaPaginaDeLaTiendaVirtualDeMascotasYTengoUnAnimalEnMiCarrito() {
        try {
            configurarNavegador();
            LOGGER.info("Inicio de la Automatizacion");
            theActorInTheSpotlight().wasAbleTo(new AbrirPaginaInicial());
            theActorInTheSpotlight().attemptsTo(
                    irAPerros(),
                    agregarAlCarrito()
            );
        }catch (Exception e){
            handleException(e);
        }
    }

    @When("elimino ese animal de la orden de compra")
    public void eliminoEseAnimalDeLaOrdenDeCompra() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    eliminarAnimal()
            );
        }catch (Exception e){
            handleException(e);
        }
    }

    @Then("deberia ver la orden de compra sin el animal eliminado")
    public void deberiaVerLaOrdenDeCompraSinElAnimalEliminado() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(mensajeCarritoVacio(), equalTo("Your cart is empty."))
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
