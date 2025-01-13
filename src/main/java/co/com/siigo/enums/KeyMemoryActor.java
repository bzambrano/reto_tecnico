package co.com.siigo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum KeyMemoryActor {

    DATA_JSON_REQUEST_CREATE_USER("DataJsonRequestCreateUser"),
    RESPONSE_SERVICE_TO_CREATE_USER("ResponseServiceToCreateUser"),
    RESPONSE_SERVICE_NEW_USER_ID("ResponseServiceNewUserId"),

    DATA_JSON_REQUEST_UPDATE_USER("DataJsonRequestUpdateUser"),
    RESPONSE_SERVICE_UPDATE_USER("ResponseServiceUpdateUser"),

    DATA_JSON_REQUEST_DELETE_USER("DataJsonRequestDeleteUser"),
    RESPONSE_SERVICE_DELETE_USER("ResponseServiceDeleteUser");

    private final String key;
}
