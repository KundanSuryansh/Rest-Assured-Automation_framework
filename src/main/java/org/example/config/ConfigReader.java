package org.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try(FileInputStream fs = new FileInputStream("src/test/resources/config.properties")){
            properties.load(fs);
        } catch (IOException e){
            throw new RuntimeException("Failed to load config.properties",e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
