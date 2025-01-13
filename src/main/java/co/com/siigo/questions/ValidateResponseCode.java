package co.com.siigo.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class ValidateResponseCode implements Question<Boolean> {

    private final Integer expectedCode;
    private final Integer actualCode;

    @Override
    public Boolean answeredBy(Actor actor) {
        return actualCode.equals(expectedCode);
    }

    public static ValidateResponseCode http(Integer expectedCode, Integer actualCode) {
        return new ValidateResponseCode(expectedCode, actualCode);
    }
}
