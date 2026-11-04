package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import  config.configReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class baseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        String br= configReader.getProperty("browser");
        String url= configReader.getProperty("url");
        String hubUrl= configReader.getProperty("hubUrl");
        String executionEnv= configReader.getProperty("exec_env");

        if(executionEnv.equalsIgnoreCase("remote")){
            DesiredCapabilities des =new DesiredCapabilities();
            switch (br.toLowerCase()){
                case "chrome":
                    des.setBrowserName("chrome");
                    break;
                case "firefox":
                    des.setBrowserName("firefox");
                    break;
                case "edge":
                    des.setBrowserName("edge");
                    break;
                default:
                    System.out.println("INVALID BROWSER");
                    return;
            }
            driver=new RemoteWebDriver(new URL(hubUrl),des);
        }else {
            switch (br.toLowerCase()){
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                default:
                    System.out.println("INVALID BROWSER");
                    return;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
