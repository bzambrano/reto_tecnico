package co.com.siigo.tasks.ui;

import co.com.siigo.interactions.ui.ClickAtCoordinates;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.siigo.userinterfaces.SalesSiigoPosUserinterface.PRODUCT_UAT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectAvailableProduct implements Task {

    public static SelectAvailableProduct fromList() {
        return instrumented(SelectAvailableProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitForFlutterViewToBeVisible.waitUntilVisible(),
                ClickAtCoordinates.at(PRODUCT_UAT)
        );
    }
}
