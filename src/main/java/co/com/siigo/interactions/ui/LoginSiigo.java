package co.com.siigo.interactions.ui;

import co.com.siigo.model.User;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.Duration;

import static co.com.siigo.userinterfaces.LoginSiigoUserinterface.BTN_SIGN_IN;
import static co.com.siigo.userinterfaces.LoginSiigoUserinterface.INPUT_PASSWORD;
import static co.com.siigo.userinterfaces.LoginSiigoUserinterface.INPUT_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class LoginSiigo implements Interaction {

    private User user;

    public static LoginSiigo byUser(User user) {
        return instrumented(LoginSiigo.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getEmail()).into(INPUT_USER.waitingForNoMoreThan(Duration.ofSeconds(30))),
                Enter.theValue(user.getPassword()).into(INPUT_PASSWORD.waitingForNoMoreThan(Duration.ofSeconds(30))),
                Click.on(BTN_SIGN_IN.waitingForNoMoreThan(Duration.ofSeconds(30)))
        );
    }
}
