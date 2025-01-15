package co.com.siigo.tasks;

import co.com.siigo.interactions.GoToPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class AccessApplication implements Task {

    private final String url;
    private final Interaction loginStrategy;


    public static AccessApplication siigo(String url,  Interaction loginStrategy) {
        return instrumented(AccessApplication.class,url, loginStrategy);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                GoToPage.openUrl(url),
                loginStrategy
        );
    }
}
