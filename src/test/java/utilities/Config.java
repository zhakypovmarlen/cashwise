package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties;
    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("/Users/marlen/Desktop/JavaProjects/IntellijIdeaProjects/cashwise/src/test/resources/configurations.properties");
            properties.load(file);
            file.close();
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }
}
