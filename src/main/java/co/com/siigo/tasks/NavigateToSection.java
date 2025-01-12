package co.com.siigo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.Duration;

import static co.com.siigo.userinterfaces.DashboardUserinterface.BTN_CREATE;
import static co.com.siigo.userinterfaces.DashboardUserinterface.CLIENTS_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToSection implements Task {

    public static NavigateToSection createClient() {
        return instrumented(NavigateToSection.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CREATE.waitingForNoMoreThan(Duration.ofSeconds(30))),
                Click.on(CLIENTS_OPTION.waitingForNoMoreThan(Duration.ofSeconds(30)))
        );
    }
}
