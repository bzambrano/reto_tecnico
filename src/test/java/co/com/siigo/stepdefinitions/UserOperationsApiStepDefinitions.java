package co.com.siigo.stepdefinitions;

import co.com.siigo.questions.ValidateResponseCode;
import co.com.siigo.questions.ValidateUserData;
import co.com.siigo.tasks.api.CreateNewUser;
import co.com.siigo.tasks.api.DeleteUserData;
import co.com.siigo.tasks.api.GetDataCreate;
import co.com.siigo.tasks.api.UpdateUserData;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;

import static co.com.siigo.enums.KeyMemoryActor.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UserOperationsApiStepDefinitions {

    @Dado("que el {actor} cuenta con datos validos para la {} de un usuario")
    public void obtenerDatosValidosConsulta(Actor actor, String nameReferenceData) {
        actor.attemptsTo(
                GetDataCreate.newUser(nameReferenceData)
        );
    }

    @Cuando("envia una solicitud para crear un nuevo usuario")
    public void enviaSolicitudCrearNuevoUsuario() {
        theActorInTheSpotlight().attemptsTo(
                CreateNewUser.throughService()
        );
    }

    @Entonces("la respuesta debe tener el codigo de estado {int}")
    public void validarCodigoRespuestaServicio(int codigo) {
        theActorInTheSpotlight()
                .should(seeThat(ValidateResponseCode.http(codigo, SerenityRest.lastResponse().statusCode())));
    }

    @Entonces("el cuerpo de la respuesta debe incluir el id del usuario creado")
    public void validarRespuestaUsuarioCreado() {
        theActorInTheSpotlight().should(seeThat(
                ValidateUserData.matchesRequestResponse(
                        theActorInTheSpotlight().recall(DATA_JSON_REQUEST_CREATE_USER.getKey()),
                        theActorInTheSpotlight().recall(RESPONSE_SERVICE_TO_CREATE_USER.getKey())
                )
        ));
    }

    @Cuando("envia una solicitud para actualizar el usuario creado")
    public void enviaSolicitudActualizarUsuario() {
        theActorInTheSpotlight().attemptsTo(
                UpdateUserData.throughService()
        );
    }

    @Entonces("el cuerpo de la respuesta debe reflejar los datos actualizados")
    public void cuerpoRespuestaDebeReflejarDatosActualizados() {
        theActorInTheSpotlight().should(seeThat(
                ValidateUserData.matchesRequestResponse(
                        theActorInTheSpotlight().recall(DATA_JSON_REQUEST_UPDATE_USER.getKey()),
                        theActorInTheSpotlight().recall(RESPONSE_SERVICE_UPDATE_USER.getKey())
                )
        ));
    }

    @Cuando("envia una solicitud eliminar el usuario creado")
    public void enviaSolicitudEliminarUsuarioCreado() {
        theActorInTheSpotlight().attemptsTo(
                DeleteUserData.throughService()
        );
    }
}