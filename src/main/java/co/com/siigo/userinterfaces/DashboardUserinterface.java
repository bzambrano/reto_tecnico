package co.com.siigo.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class DashboardUserinterface {

    private DashboardUserinterface() {
    }

    public static final Target BTN_CREATE = Target.the("Botón + crear ")
            .located(ByShadow.cssSelector("siigo-button-atom[data-id='header-create-button']",
                    "siigo-header-molecule[class*='data-siigo-five9']")
            );

    public static final Target CLIENTS_OPTION = Target
            .the("opcion de clientes ")
            .located(ByShadow.cssSelector("li a[data-value='Clientes']",
                    "siigo-header-molecule[class*='data-siigo-five9']"));

}
