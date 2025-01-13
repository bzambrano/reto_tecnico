package co.com.siigo.questions;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.path.json.JsonPath;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.siigo.enums.UserFields.JOB;
import static co.com.siigo.enums.UserFields.NAME;

@AllArgsConstructor
public class ValidateUserData implements Question<Boolean> {

    JsonNode jsonRequest;
    JsonPath jsonResponse;

    public static ValidateUserData matchesRequestResponse(JsonNode jsonRequest, JsonPath jsonResponse) {
        return new ValidateUserData(jsonRequest, jsonResponse);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String requestName = jsonRequest.get(NAME.getField()).asText();
        String requestJob = jsonRequest.get(JOB.getField()).asText();

        String responseName = jsonResponse.getString(NAME.getField());
        String responseJob = jsonResponse.getString(JOB.getField());

        boolean isNameMatching = requestName.equals(responseName);
        boolean isJobMatching = requestJob.equals(responseJob);

        if (!isNameMatching) {
            Serenity.recordReportData()
                    .withTitle("Name Mismatch")
                    .andContents("Expected Name: **" + requestName + "** but got: **" + responseName + "**");
        } else {
            Serenity.recordReportData()
                    .withTitle("Name Validation")
                    .andContents("Name matched successfully: **" + requestName + "**");
        }

        if (!isJobMatching) {
            Serenity.recordReportData()
                    .withTitle("Job Mismatch")
                    .andContents("Expected Job: **" + requestJob + "** but got: **" + responseJob + "**");
        } else {
            Serenity.recordReportData()
                    .withTitle("Job Validation")
                    .andContents("Job matched successfully: **" + requestJob + "**");
        }

        return isNameMatching && isJobMatching;
    }
}
