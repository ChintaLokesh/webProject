package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class BaseClass {
private final Logger log = LogManager.getLogger(BaseClass.class);
    WebDriver driver;
    @BeforeTest
    public void configure() throws IOException {
        try {
            log.info("Triggered Before Test");
            String browserType=System.getProperty("browserType");
            if(browserType == null)
            {
                driver = new EdgeDriver();
                driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            }

            else if(browserType.equalsIgnoreCase("edge")) {
                log.info("Browser Type passed from command prompt is:",browserType);
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.setAcceptInsecureCerts(true);
//                URL url = new URL("http://192.168.1.10:4444/wd/hub");

//                driver = new RemoteWebDriver(url, options);
                driver = new EdgeDriver();
                driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
            }
            else if(browserType.equals("chrome") )
            {
                log.info("Browser Type passed from command prompt is:",browserType);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
//                driver=new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),options);

                driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
            }
            else if(browserType.equalsIgnoreCase("local"))
            {
                driver = new EdgeDriver();
                driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            }
            log.info("driver instance:",driver);
            driver.manage().window().maximize();
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/Screenshots/"+"driverInstance"+".jpg"));
        }
        finally
        {

        }
    }

    @AfterTest
    public void tearDown()
    {
        System.out.println("Triggered After Test");
        if(driver !=null){
        driver.quit();}
    }
}
