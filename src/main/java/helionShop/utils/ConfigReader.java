package helionShop.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE_PATH = "src\\main\\java\\helionShop\\config.txt";

    public static String getLogin() {
        return getProperty("login");
    }

    public static String getPassword() {
        return getProperty("password");
    }

    private static String getProperty(String propertyName) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
            return properties.getProperty(propertyName);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}