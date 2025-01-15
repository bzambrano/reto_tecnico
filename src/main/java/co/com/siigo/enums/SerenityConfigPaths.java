package co.com.siigo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor @Getter
public enum SerenityConfigPaths {
    LOGIN("environments.qa.ui.url.login.test"),
    LOGIN_POS("environments.qa.ui.url.login.pos"),
    USER_EMAIL("environments.qa.credentials.user.email.test"),
    PASSWORD("environments.qa.credentials.user.password.test"),
    USER_EMAIL_POS("environments.qa.credentials.user.email.pos"),
    PASSWORD_POS("environments.qa.credentials.user.password.pos"),
    URL_BASE("environments.qa.api.url"),
    RESOURCE_CREATE_PATH ("environments.qa.api.create.resource");

    private final String path;
}
