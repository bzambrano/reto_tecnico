package co.com.siigo.interactions.ui;

import co.com.siigo.model.User;
import co.com.siigo.tasks.ui.WaitForFlutterViewToBeVisible;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static co.com.siigo.userinterfaces.LoginSiigoPosUserinterface.INPUT_EMAIL;
import static co.com.siigo.userinterfaces.LoginSiigoPosUserinterface.BTN_SIGN_IN;
import static co.com.siigo.userinterfaces.LoginSiigoPosUserinterface.INPUT_PASSWORD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class LoginSiigoPos implements Interaction {

    private User user;

    public static LoginSiigoPos byUser(User user) {
        return instrumented(LoginSiigoPos.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitForFlutterViewToBeVisible.waitUntilVisible(),
                EnterTextAtCoordinates.at(INPUT_EMAIL, user.getEmail()),
                EnterTextAtCoordinates.at(INPUT_PASSWORD , user.getPassword()),
                ClickAtCoordinates.at(BTN_SIGN_IN)
        );
    }
}
