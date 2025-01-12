package co.com.siigo.tasks;

import co.com.siigo.interactions.GoToPage;
import co.com.siigo.interactions.Login;
import co.com.siigo.model.User;
import co.com.siigo.utils.ConfigReaderDataTest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.siigo.enums.SerenityConfigPaths.LOGIN;
import static co.com.siigo.utils.TestDataFactory.createUser;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AccessApplication implements Task {

    public static AccessApplication siigo() {
        return instrumented(AccessApplication.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        User user = createUser();
        String url = ConfigReaderDataTest.get(LOGIN.getPath());

        actor.attemptsTo(
                GoToPage.openUrl(url),
                Login.byUser(user)
        );
    }
}
