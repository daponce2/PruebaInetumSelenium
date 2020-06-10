package web.com.bdd.lib;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {


    public static WebDriver setWebDriver(String browser) throws MalformedURLException {
        System.out.println("Ejecutando en: " + browser);

        WebDriver webDriver;


                if (browser.equalsIgnoreCase("chrome")) {
                    String BASE_PATH = System.getProperty("user.dir");

                    //String BASE_PATH = allPath.split("\\\\continuous_testing_base\\\\")[0];
                    ChromeOptions options = new ChromeOptions();
                    if (System.getProperty("os.name").contains("Mac")) {
                        BASE_PATH = BASE_PATH + "/drivers/chromedriver";
                    } else {
                        BASE_PATH = BASE_PATH + "/drivers/chromedriver.exe";
                        options.setExperimentalOption("useAutomationExtension", false);
                    }
                    System.setProperty("webdriver.chrome.driver", BASE_PATH);
                    webDriver = new ChromeDriver(options);

                } else if (browser.equalsIgnoreCase("ie")) {
                    String BASE_PATH = System.getProperty("user.dir") + "\\";
                    BASE_PATH = BASE_PATH + "drivers/IEDriverServer32.exe";
                    System.setProperty("webdriver.ie.driver", BASE_PATH);
                    webDriver = new InternetExplorerDriver();
                } else {
                    throw new IllegalArgumentException("Browser type not supported: " + browser);
                }
                webDriver.manage().window().maximize();

        return webDriver;



    }


//}

}