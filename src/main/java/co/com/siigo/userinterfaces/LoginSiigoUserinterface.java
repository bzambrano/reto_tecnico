package co.com.siigo.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class LoginSiigoUserinterface {

    private LoginSiigoUserinterface() {
    }

    public static final Target INPUT_USER = Target.the("Ingresar usuario")
            .located(ByShadow.cssSelector("input[name='username-input']",
                    "input-atom[input-id='username-input']"));

    public static final Target INPUT_PASSWORD = Target.the("Ingresar contraseña ")
            .located(ByShadow.cssSelector("input[name='password-input']",
                    "input-atom[id='current-password']"));

    public static final Target BTN_SIGN_IN  = Target.the("Botón ingresar ")
            .located(By.cssSelector("button#login-submit"));


}
