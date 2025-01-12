package co.com.siigo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ActorNames {

    NOMBRE_ACTOR_DEFAULT ("Usuario");

    private final String actorName;
}
