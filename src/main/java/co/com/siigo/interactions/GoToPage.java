package co.com.siigo.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class GoToPage implements Interaction {

    private String url;

    public static GoToPage openUrl(String url) {
        return instrumented(GoToPage.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Open.url(url).performAs(actor);
    }
}
