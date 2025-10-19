package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReUsableMethods {

    WebDriver driver;
   public  ReUsableMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    public void takeScreenshot(String name) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
            File file = new File(System.getProperty("user.dir")+"/Screenshots");
            file.mkdir();
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileName=LocalDateTime.now().format(formatter).toString()+"_"+name;
            FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/Screenshots/" + fileName+".png"));
        }
        catch(IOException exception)
        {
            System.out.println(exception.getMessage());
        }
    }

}
