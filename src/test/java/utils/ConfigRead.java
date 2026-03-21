package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigRead {

    private static final Properties prop;

    static {
        try {
            // Get config path from system property
            String configPath = System.getProperty("config.path");
            if (configPath == null) {
                configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            }
            FileInputStream fis = new FileInputStream(configPath);
            prop= new Properties();
            prop.load(fis);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String getBaseUrl() {
        return prop.getProperty("base.url");
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
