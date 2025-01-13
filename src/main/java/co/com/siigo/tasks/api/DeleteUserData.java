package co.com.siigo.tasks.api;

import co.com.siigo.enums.JsonBaseRequest;
import co.com.siigo.model.DataForRequest;
import co.com.siigo.utils.GetJsonBase;
import com.fasterxml.jackson.databind.JsonNode;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.siigo.enums.JsonBaseRequest.REQUEST_CREATE_USER;
import static co.com.siigo.enums.KeyMemoryActor.*;
import static co.com.siigo.utils.JsonRandomizer.randomizeJson;
import static co.com.siigo.utils.TestDataFactory.getCreateUserServiceRequest;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserData implements Task {

    public static DeleteUserData throughService() {
        return instrumented(DeleteUserData.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String id = actor.recall(RESPONSE_SERVICE_NEW_USER_ID.getKey());
        JsonBaseRequest jsonBaseRequest = JsonBaseRequest.findByName(REQUEST_CREATE_USER.getName());
        JsonNode jsonBase = GetJsonBase.loadJsonFromFile(jsonBaseRequest);
        JsonNode body = randomizeJson(jsonBase);
        actor.remember(DATA_JSON_REQUEST_DELETE_USER.getKey(), body);

        DataForRequest dataForRequest = getCreateUserServiceRequest();
        actor.can(CallAnApi.at(dataForRequest.getUrl()));
        actor.attemptsTo(
                Delete.from(dataForRequest.getPath()+"/"+id)
                        .with(
                                req -> req
                                        .body(body)
                        )
        );
        actor.remember(RESPONSE_SERVICE_DELETE_USER.getKey(), SerenityRest.lastResponse().getBody().jsonPath());
    }
}