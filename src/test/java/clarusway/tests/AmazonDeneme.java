package clarusway.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AmazonDeneme {

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

    @DataProvider
    public Object[][] aramaData(){
        Object[][] arama=new Object[2][1];
        arama[0][0]="MSI";
        arama[1][0]="APPLE";
        return arama;
    }

    @Test(dataProvider = "aramaData")
    public void test(String aramalarca) {
        driver.get("https://www.amazon.com.tr/");
        String homePageUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.amazon.com.tr/",homePageUrl);
        WebElement cerez = driver.findElement(By.name("accept"));
        cerez.click();
        Actions actions=new Actions(driver);
        WebElement hesapListelerButton = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(hesapListelerButton).perform();
        WebElement girisYapButton = driver.findElement(By.linkText("Giriş yap"));
        girisYapButton.click();
        WebElement ePosta = driver.findElement(By.id("ap_email"));
        ePosta.sendKeys("bostanebubekir@gmail.com"+ Keys.ENTER);
        WebElement sifre = driver.findElement(By.id("ap_password"));
        sifre.sendKeys("6121.bkr"+ Keys.ENTER);
        WebElement loginControl= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Assert.assertTrue(!loginControl.getText().contains("Merhaba, Giriş yapın"));
        WebElement kategoriler = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(kategoriler);
        select.selectByVisibleText("Bilgisayarlar");
        WebElement pc = select.getFirstSelectedOption();
        Assert.assertTrue(pc.isSelected());
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(aramalarca+Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement ikinciSayfa = driver.findElement(By.linkText("2"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();" ,ikinciSayfa);
        ikinciSayfa.click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-label='Geçerli sayfa, sayfa 2']")).isDisplayed());
        WebElement ikinciUrun = driver.findElement(By.xpath("(//h2/a)[2]"));
        ikinciUrun.click();
        WebElement listeyeEkle = driver.findElement(By.name("submit.add-to-registry.wishlist"));
        listeyeEkle.click();
        WebElement listeGor = driver.findElement(By.linkText("Listenizi Görüntüleyin"));
        listeGor.click();
        WebElement listedekiUrun = driver.findElement(By.xpath("//h2/a"));
        Assert.assertTrue(listedekiUrun.isDisplayed());
        WebElement hesapListelerButton1 = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(hesapListelerButton1).perform();
        WebElement favori = driver.findElement(By.linkText("Alışveriş Listesi"));
        favori.click();
        WebElement alisverisList = driver.findElement(By.id("profile-list-name"));
        Assert.assertTrue(alisverisList.isDisplayed());
        WebElement kaldir = driver.findElement(By.name("submit.deleteItem"));
        kaldir.click();
        WebElement silindi = driver.findElement(By.xpath("//div[.='Silindi']"));
        Assert.assertTrue(silindi.isDisplayed());
        WebElement hesapListelerButton2 = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(hesapListelerButton2).perform();
        WebElement logOut = driver.findElement(By.linkText("Çıkış Yap"));
        logOut.click();
        WebElement girisYap = driver.findElement(By.xpath("//div/h1"));
        Assert.assertTrue(girisYap.isDisplayed());
    }
}
