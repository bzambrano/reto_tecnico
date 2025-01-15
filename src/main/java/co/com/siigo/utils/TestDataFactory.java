package co.com.siigo.utils;

import co.com.siigo.model.DataForRequest;
import co.com.siigo.model.User;
import lombok.experimental.UtilityClass;

import static co.com.siigo.enums.SerenityConfigPaths.*;
@UtilityClass
public class TestDataFactory {

    private static final String USER_EMAIL_KEY = USER_EMAIL.getPath();
    private static final String PASSWORD_KEY = PASSWORD.getPath();
    private static final String USER_EMAIL_POS_KEY = USER_EMAIL_POS.getPath();
    private static final String PASSWORD_POS_KEY = PASSWORD_POS.getPath();
    private static final String URL_BASE_KEY = URL_BASE.getPath();
    private static final String RESOURCE_CREATE_PATH_KEY = RESOURCE_CREATE_PATH.getPath();

    public static User createUser() {
        return buildUser(USER_EMAIL_KEY, PASSWORD_KEY);
    }

    public static User createUserPos() {
        return buildUser(USER_EMAIL_POS_KEY, PASSWORD_POS_KEY);
    }

    public static DataForRequest getCreateUserServiceRequest() {
        return DataForRequest.builder()
                .url(ConfigReaderDataTest.get(URL_BASE_KEY))
                .path(ConfigReaderDataTest.get(RESOURCE_CREATE_PATH_KEY))
                .build();
    }

    private static User buildUser(String emailKey, String passwordKey) {
        return User.builder()
                .email(getDecodedConfig(emailKey))
                .password(getDecodedConfig(passwordKey))
                .build();
    }

    private static String getDecodedConfig(String key) {
        return DataDecoder.decode(ConfigReaderDataTest.get(key));
    }
}