package co.com.siigo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor @Getter
public enum SerenityConfigPaths {
    LOGIN("environments.qa.ui.url.login"),
    USER_EMAIL("environments.qa.credentials.user.email"),
    PASSWORD("environments.qa.credentials.user.password");

    private final String path;
}
