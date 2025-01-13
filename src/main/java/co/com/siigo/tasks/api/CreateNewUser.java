package co.com.siigo.tasks.api;

import co.com.siigo.model.DataForRequest;
import com.fasterxml.jackson.databind.JsonNode;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.siigo.enums.KeyMemoryActor.*;
import static co.com.siigo.enums.UserFields.ID;
import static co.com.siigo.utils.TestDataFactory.getCreateUserServiceRequest;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateNewUser implements Task {


    public static CreateNewUser throughService() {
        return instrumented(CreateNewUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JsonNode body = actor.recall(DATA_JSON_REQUEST_CREATE_USER.getKey());
        DataForRequest dataForRequest = getCreateUserServiceRequest();
        actor.can(CallAnApi.at(dataForRequest.getUrl()));
        actor.attemptsTo(
                Post.to(dataForRequest.getPath())
                        .with(
                                req -> req
                                        .body(body)
                        )
        );
        String id = SerenityRest.lastResponse().jsonPath().getString(ID.getField());

        actor.remember(RESPONSE_SERVICE_TO_CREATE_USER.getKey(), SerenityRest.lastResponse().getBody().jsonPath());
        actor.remember(RESPONSE_SERVICE_NEW_USER_ID.getKey(), id);

    }

}
