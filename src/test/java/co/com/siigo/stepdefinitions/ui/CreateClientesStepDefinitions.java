package co.com.siigo.stepdefinitions.ui;

import co.com.siigo.tasks.NavigateToSection;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateClientesStepDefinitions {

    @Dado("ingresa a la seccion de creacion de clientes")
    public void ingresaAlaSeccionDeCreacionDeClientes() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToSection.createClient()
        );
    }

    @Cuando("diligencian los campos requeridos para crear un nuevo cliente")
    public void diligencianLosCamposRequeridosParaCrearUnNuevoCliente() {
    }

    @Entonces("se debe crear un nuevo cliente exitosamente")
    public void seDebeCrearUnNuevoClienteExitosamente() {
    }

}
