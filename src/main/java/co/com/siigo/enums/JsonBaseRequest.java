package co.com.siigo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor @Getter
public enum JsonBaseRequest {

    REQUEST_CREATE_USER ("creacion", "src/test/resources/basic_data_for_requests/create_user.json"),
    REQUEST_UPDATE_USER ("actualizacion", "src/test/resources/basic_data_for_requests/create_user.json");

    private final String name;
    private final String filePath;

    public static JsonBaseRequest findByName(String name) {
        return Arrays.stream(JsonBaseRequest.values())
                .filter(message -> message.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Message with name does not exist: " + name));
    }
}


