package clarusway.tests;

import clarusway.utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task03 extends BaseTest {
    /*
    Test Case1: Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Puch Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in')
Verify button Log out is displayed on the new page.
     */

    @Test
    public void loginTest() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameButton = driver.findElement(By.id("username"));
        usernameButton.sendKeys("student");
        WebElement passwordButton = driver.findElement(By.id("password"));
        passwordButton.sendKeys("Password123");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        String url = driver.getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));
        WebElement message= driver.findElement(By.tagName("html"));
        softAssert.assertTrue(message.getText().contains("Congratulations") || message.getText().contains("successfully logged in") );
        WebElement logOut= driver.findElement(By.linkText("Log out"));
        softAssert.assertTrue(logOut.isDisplayed(),"Log out görüntülenemiyor.");
        softAssert.assertAll();





    }
}
