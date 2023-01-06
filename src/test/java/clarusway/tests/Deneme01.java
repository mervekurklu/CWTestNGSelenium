package clarusway.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Deneme01 {

    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserName) {
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

 //  @DataProvider
 //  public Object[][] aramaData(){
 //      Object [][] arama =new Object[2][1];
 //      arama[0][0]="apple";
 //      arama[1][0]="oppo";
 //      return arama;
 //  }

    @Test
    public void testName() {
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("apple"+ Keys.ENTER);
        WebElement result= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(result.isDisplayed());
    }
}
