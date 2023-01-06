package clarusway.tests;

import clarusway.utilities.BaseCrossBrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task07 extends BaseCrossBrowserTest {

    /*
Open the site http://opencart.abstracta.us/
Using the Search function do it with Data Provider for Mac, iPad and Samsung
     */

    @Test(dataProvider = "dataName")
    public void test(String key) {
        driver.get("http://opencart.abstracta.us/");
        WebElement searchBox= driver.findElement(By.name("search"));
        searchBox.sendKeys(key+ Keys.ENTER);

    }

    @DataProvider
    public Object[][] dataName(){
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}
