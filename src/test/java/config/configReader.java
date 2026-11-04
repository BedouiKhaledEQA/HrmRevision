package config;

import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    public WebDriver driver;
    public static Properties props =new Properties();

    static {
        try {
            FileReader file =new FileReader("src/test/java/resources/local_config.properties");
            props.load(file);
            file.close();
        }catch (IOException e){
            throw new RuntimeException("FAILED TO LOAD CONFIGURATION",e);
        }
    }
    public static String getProperty(String key){
        return props.getProperty(key);
    }
}
