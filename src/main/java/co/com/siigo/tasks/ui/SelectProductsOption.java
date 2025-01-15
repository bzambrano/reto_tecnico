package co.com.siigo.tasks.ui;

import co.com.siigo.interactions.ui.ClickAtCoordinates;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.siigo.userinterfaces.SalesSiigoPosUserinterface.BTN_PRODUCTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProductsOption implements Task {

    public static SelectProductsOption fromMenu() {
        return instrumented(SelectProductsOption.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitForFlutterViewToBeVisible.waitUntilVisible(),
                ClickAtCoordinates.at(BTN_PRODUCTS)
        );
    }
}
