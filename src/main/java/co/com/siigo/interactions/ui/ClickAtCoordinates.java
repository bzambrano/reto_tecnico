package co.com.siigo.interactions.ui;

import co.com.siigo.model.ElementCoordinates;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ClickAtCoordinates implements Interaction {

    private final ElementCoordinates elementCoordinates;

    public static ClickAtCoordinates at(ElementCoordinates elementCoordinates) {
        return instrumented(ClickAtCoordinates.class, elementCoordinates);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int x = elementCoordinates.getX();
        int y = elementCoordinates.getY();

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);

        actions.moveByOffset(x, y).click().perform();
        actions.moveByOffset(-x, -y).perform();
    }
}