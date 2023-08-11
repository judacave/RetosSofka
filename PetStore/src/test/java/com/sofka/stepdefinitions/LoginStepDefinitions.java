package com.sofka.stepdefinitions;

import com.sofka.setup.Setup;
import com.sofka.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofka.questions.ComprobacionLogin.comprobacionLogin;
import static com.sofka.questions.MensajeReptiles.mensajeReptiles;
import static com.sofka.tasks.IngresarCredenciales.ingresarCredenciales;
import static com.sofka.tasks.IniciarSesion.iniciarSesion;
import static com.sofka.tasks.IrALogin.irALogin;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinitions extends Setup {

    public static Logger LOGGER = Logger.getLogger(ListarReptilesStepDefinitions.class);
    @Given("que estoy en la pagina de inicio de sesion")
    public void queEstoyEnLaPaginaDeInicioDeSesion() {
        try {
            configurarNavegador();
            LOGGER.info("Inicio de la Automatizacion");
            theActorInTheSpotlight().wasAbleTo(new AbrirPaginaInicial());
            theActorInTheSpotlight().attemptsTo(
                    irALogin()
            );
        }catch (Exception e){
            handleException(e);
        }
    }

    @When("ingreso mi nombre de usuario mi_usuario y contrasenna mi_clave")
    public void ingresoMiNombreDeUsuarioMi_usuarioYContrasennaMi_clave() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    ingresarCredenciales()
            );
        }catch (Exception e){
            handleException(e);
        }
    }
    @When("hago clic en el boton de inicio de sesion")
    public void hagoClicEnElBotonDeInicioDeSesion() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
            );
        }catch (Exception e){
            handleException(e);
        }
    }

    @Then("deberia ver la pagina de inicio de usuario")
    public void deberiaVerLaPaginaDeInicioDeUsuario() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(comprobacionLogin(), equalTo("My Account"))
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
