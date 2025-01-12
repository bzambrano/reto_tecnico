package co.com.siigo.utils;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class ConfigReaderDataTest {

    private ConfigReaderDataTest() {
    }

    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String get(String key) {
        return environmentVariables.getProperty(key);
    }
}
