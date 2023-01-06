package clarusway.tests;

import clarusway.utilities.BaseCrossBrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task06 extends BaseCrossBrowserTest {
    /*
    Go to URL: https://opensource-demo.orangehrmlive.com/
    Login with negative credentilas by Data Provider.
    Then assert that ‘’Invalid credentials’’ is displayed
     */

    @Test(dataProvider = "data")
    public void test01(String name,String password) {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userName= driver.findElement(By.name("username"));
        userName.sendKeys(name);
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys(password);
        WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        WebElement message= driver.findElement(By.xpath("//p[.='Invalid credentials']"));
        Assert.assertTrue(message.isDisplayed());


    }


    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"admin","12345"}

        };
    }
}
