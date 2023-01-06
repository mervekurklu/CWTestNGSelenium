package clarusway.tests.CalismaClass;

import clarusway.utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SliderTask extends BaseTest {
    /*
    1) Open the browser
2) Enter the URL "http://practice.automationtesting.in/"
3) Click on Shop Menu
4) Adjust the filter by price between 150 to 450 rps
5) Now click on Filter button
6) User can view books only between 150 to 450 rps price
     */

    @Test
    public void testName() throws InterruptedException {
        driver.get("http://practice.automationtesting.in/");
        WebElement shopLink= driver.findElement(By.linkText("Shop"));
        shopLink.click();
        WebElement slider2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement slider1 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        actions.dragAndDropBy(slider1,70,0).perform();
        actions.dragAndDropBy(slider2,-70,0).perform();
        Thread.sleep(3000);
    }
}
