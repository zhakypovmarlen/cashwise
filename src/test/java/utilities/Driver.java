package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    private static String browserType = Config.getValue("browser");


    public static WebDriver getDriver(){
        if(driver == null){
            if(browserType.equals("chrome")){
                driver = new ChromeDriver();
            } else if(browserType.equals("firefox")){
                driver = new FirefoxDriver();
            } else if(browserType.equals("edge")){
                driver = new EdgeDriver();
            } else {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        }
        return driver;
    }

    public static void quit() {
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
