package org.example;

import org.ObjectRepository.CreditCardPayment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ReUsableMethods;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class ThirdTest extends BaseClass {

    ReUsableMethods reUsableMethods;
    private final Logger log = Logger.getLogger(String.valueOf(ThirdTest.class));
    CreditCardPayment creditCardPayment;
    @BeforeClass
    public void conf()
    {
        log.info("Before Method started");
        reUsableMethods= new ReUsableMethods(driver);
    }
//    @Test
    public void testDragAndDrop()
    {
        driver.navigate().to("https://artoftesting.com/samplesiteforselenium");
        WebElement image=driver.findElement(By.id("myImage"));
        Actions actions = new Actions(driver);
        WebElement target=driver.findElement(By.id("targetDiv"));
        actions.moveToElement(image).build().perform();
        actions.dragAndDrop(image,target).perform();
        reUsableMethods.takeScreenshot("DragAndDropScreenshot");
    }

//    @Test
    public void testRadioButton()
    {
        List<WebElement> list=driver.findElements(By.xpath("//input[@type='radio']"));
        WebElement wb=list.stream().filter(element -> element.getAttribute("value").equals("male"))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException());

        wb.click();
        reUsableMethods.takeScreenshot("RadioButton");
    }

    @Test
    public void testLink()
    {
        driver.navigate().to("https://artoftesting.com/samplesiteforselenium");
//        WebElement wb=driver.findElement(By.xpath("//a[@href='http://www.artoftesting.com/sampleSiteForSelenium.html']"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("http://www.artoftesting.com/sampleSiteForSelenium.html");
        reUsableMethods.takeScreenshot("newTab");
    }

}
