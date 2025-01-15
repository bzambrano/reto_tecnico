package co.com.siigo.stepdefinitions.ui;

import co.com.siigo.interactions.ui.LoginSiigoPos;
import co.com.siigo.model.User;
import co.com.siigo.tasks.AccessApplication;
import co.com.siigo.tasks.ui.ChargeForAvailableProduct;
import co.com.siigo.tasks.ui.SelectAvailableProduct;
import co.com.siigo.tasks.ui.SelectProductsOption;
import co.com.siigo.utils.ConfigReaderDataTest;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static co.com.siigo.enums.SerenityConfigPaths.LOGIN_POS;
import static co.com.siigo.utils.TestDataFactory.createUserPos;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ChargeGenericProductStepDefinitions {

    private String urlLoginPos = ConfigReaderDataTest.get(LOGIN_POS.getPath());
    private User user = createUserPos();
    private Interaction loginStrategy = LoginSiigoPos.byUser(user);

    @Dado("que el {actor} ingresa a la aplicacion Siigo.pos")
    public void actorIngresarAplicacionSiigiPos(Actor actor) {

        actor.attemptsTo(
                AccessApplication.siigo(urlLoginPos, loginStrategy)
        );

    }

    @Cuando("ingresa a la seccion de productos")
    public void ingresaSeccionProductos() {
        theActorInTheSpotlight().attemptsTo(
                SelectProductsOption.fromMenu(),
                SelectAvailableProduct.fromList()
        );
    }

    @Cuando("realizar el cobro del producto disponible")
    public void realizarCobroProductoDisponible() {
        theActorInTheSpotlight().attemptsTo(
                ChargeForAvailableProduct.execute()
        );
    }

}
