package co.com.siigo.userinterfaces;

import co.com.siigo.model.ElementCoordinates;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginSiigoPosUserinterface {

    public static final Target FLUTTER_CONTAINER = Target.the("Flutter container")
            .located(By.cssSelector("flutter-view"));

    public static final ElementCoordinates INPUT_EMAIL = new ElementCoordinates("Campo de email ", 450, 435);

    public static final ElementCoordinates INPUT_PASSWORD = new ElementCoordinates("Campo de password ", 450, 512);

    public static final ElementCoordinates BTN_SIGN_IN = new ElementCoordinates("Boton de inicio de session ", 463, 609);

}
