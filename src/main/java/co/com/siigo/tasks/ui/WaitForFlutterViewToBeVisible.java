package co.com.siigo.tasks.ui;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.userinterfaces.LoginSiigoPosUserinterface.FLUTTER_CONTAINER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class WaitForFlutterViewToBeVisible implements Task {

    public static WaitForFlutterViewToBeVisible waitUntilVisible() {
        return instrumented(WaitForFlutterViewToBeVisible.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FLUTTER_CONTAINER, isVisible()).forNoMoreThan(40).seconds()
        );
    }

}
