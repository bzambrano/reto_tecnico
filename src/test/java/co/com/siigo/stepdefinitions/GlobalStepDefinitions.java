package co.com.siigo.stepdefinitions;

import co.com.siigo.tasks.AccessApplication;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;

public class GlobalStepDefinitions {

    @Dado("que el {actor} inicia sesion en la aplicacion")
    public void iniciaSesionAplicacion(Actor actor) {
        actor.attemptsTo(
                AccessApplication.siigo()
        );
    }


}
