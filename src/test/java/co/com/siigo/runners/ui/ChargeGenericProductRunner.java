package co.com.siigo.runners.ui;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/ui/ChargeGenericProduct.feature",
        glue = {"co.com.siigo.stepdefinitions",
                "co.com.siigo.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty"},
        tags = "@ChargeGenericProduct")
public class ChargeGenericProductRunner {
}
