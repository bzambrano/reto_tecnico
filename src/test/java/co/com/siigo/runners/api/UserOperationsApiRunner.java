package co.com.siigo.runners.api;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/api/reqres.feature",
        glue = {"co.com.siigo.stepdefinitions.api",
                "co.com.siigo.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty"},
        tags = "@UserOperations")
public class UserOperationsApiRunner {
}
