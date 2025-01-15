package co.com.siigo.stepdefinitions.ui;

import co.com.siigo.interactions.ui.LoginSiigo;
import co.com.siigo.model.User;
import co.com.siigo.tasks.AccessApplication;
import co.com.siigo.utils.ConfigReaderDataTest;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static co.com.siigo.enums.SerenityConfigPaths.LOGIN;
import static co.com.siigo.utils.TestDataFactory.createUser;

public class GlobalStepDefinitions {

    private String urlLogin = ConfigReaderDataTest.get(LOGIN.getPath());
    private User user = createUser();
    private Interaction loginStrategy = LoginSiigo.byUser(user);

    @Dado("que el {actor} inicia sesion en la aplicacion")
    public void iniciaSesionAplicacion(Actor actor) {
        actor.attemptsTo(
                AccessApplication.siigo(urlLogin, loginStrategy)
        );
    }

}
