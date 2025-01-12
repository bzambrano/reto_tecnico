package co.com.siigo.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.siigo.enums.ActorNames.NOMBRE_ACTOR_DEFAULT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ActorSetupHook {

    private Actor actorEscena;

    @Before(order = 0)
    public void setupActor() {
        OnStage.setTheStage(new OnlineCast());
        actorEscena = theActorCalled(NOMBRE_ACTOR_DEFAULT.getActorName());
    }

    @ParameterType(".*")
    public Actor actor(String nombreActor) {
        actorEscena.assignName(nombreActor);
        theActorInTheSpotlight().assignName(nombreActor);
        return actorEscena;
    }

}
