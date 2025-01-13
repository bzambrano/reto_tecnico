package co.com.siigo.tasks.api;

import co.com.siigo.enums.JsonBaseRequest;
import co.com.siigo.utils.GetJsonBase;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.siigo.enums.KeyMemoryActor.DATA_JSON_REQUEST_CREATE_USER;
import static co.com.siigo.utils.JsonRandomizer.randomizeJson;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class GetDataCreate implements Task {

    private String nameReferenceData;

    public static GetDataCreate newUser(String nameReferenceData) {
        return instrumented(GetDataCreate.class, nameReferenceData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JsonBaseRequest jsonBaseRequest = JsonBaseRequest.findByName(nameReferenceData);
        JsonNode jsonBase = GetJsonBase.loadJsonFromFile(jsonBaseRequest);
        JsonNode jsonRequest = randomizeJson(jsonBase);
        actor.remember(DATA_JSON_REQUEST_CREATE_USER.getKey(), jsonRequest);
    }
}
