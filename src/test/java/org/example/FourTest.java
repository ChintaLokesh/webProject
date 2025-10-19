package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ReUsableMethods;

import java.util.NoSuchElementException;
import java.util.Set;

public class FourTest extends BaseClass {

    private ReUsableMethods reUsableMethods;
    @BeforeClass
    public void configureTest()
    {
        reUsableMethods= new ReUsableMethods(driver);
    }
//    @Test(dataProvider="getData")
    public void testRadioButton(String name)
    {
       WebElement wb= driver.findElements(By.xpath("//label[contains(@for,'radio')]"))
                .stream().filter(element -> element.getText().equals(name))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException());
       wb.findElement(By.xpath(".//input")).click();
        reUsableMethods.takeScreenshot(name);

    }

    @Test
    public void testWindow()
    {
        String parentId=driver.getWindowHandle();
        String childId=null;
        String title= null;
        System.out.println("parent windowId:"+parentId);
        driver.findElement(By.id("openwindow")).click();
        Set<String> setOfStrings=driver.getWindowHandles();
        for(String s:setOfStrings){
            if(!s.equals(parentId))
            {
                childId=s;
                System.out.println("child windowId:"+childId);
            }
           }
        if(childId !=null)
        {
            driver.switchTo().window(childId);
            title=driver.getTitle();
            System.out.println("title of the window:"+title);
        }
    }

    @DataProvider(name="getData")
    public Object[] getData()
    {
        return new Object[]{"Radio1","Radio2","Radio3"};
    }
}
