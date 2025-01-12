package co.com.siigo.utils;

import co.com.siigo.model.User;

import static co.com.siigo.enums.SerenityConfigPaths.PASSWORD;
import static co.com.siigo.enums.SerenityConfigPaths.USER_EMAIL;

public class TestDataFactory {

    private TestDataFactory() {
    }

    public static User createUser() {
        String email = DataDecoder.decode(ConfigReaderDataTest.get(USER_EMAIL.getPath()));
        String password = DataDecoder.decode(ConfigReaderDataTest.get(PASSWORD.getPath()));


        return  User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
