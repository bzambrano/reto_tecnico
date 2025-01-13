package co.com.siigo.utils;

import co.com.siigo.model.DataForRequest;
import co.com.siigo.model.User;

import static co.com.siigo.enums.SerenityConfigPaths.*;

public class TestDataFactory {

    private TestDataFactory() {
    }

    public static User createUser() {
        String email = DataDecoder.decode(ConfigReaderDataTest.get(USER_EMAIL.getPath()));
        String password = DataDecoder.decode(ConfigReaderDataTest.get(PASSWORD.getPath()));

        return User.builder()
                .email(email)
                .password(password)
                .build();
    }

    public static DataForRequest getCreateUserServiceRequest() {
        String url = ConfigReaderDataTest.get(URL_BASE.getPath());
        String path = ConfigReaderDataTest.get(RESOURCE_CREATE_PATH.getPath());
        return DataForRequest.builder()
                .url(url)
                .path(path)
                .build();
    }


}
