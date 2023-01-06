package clarusway.tests;

import org.testng.annotations.*;

public class Day01_C01_TestNGAnnotations {

    //@before/After Suite
//@before/After Test
//@before/After Class
//@before/After Method

    //jUnite e göre daha gelişmiş eklentilerle çalışır test verilerini java bilgileri olarak alır. test sonuçlaırını test raporlarına gönderir
    //aşağı doğru imdikçe hepsi birbiririn başlığı olabilir
    //test methodlarımızı @test etkileyen before ve after anatasyonlarımız dır.

    @Test
    public void test01(){
        System.out.println("\t\t\t\tTest 01 calisiyor");
    }

    @Test
    public void test02(){
        System.out.println("\t\t\t\tTest 02 calisiyor");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite calisti");
    }

    @AfterSuite
    public void afterSuite(){

        System.out.println("After suite calisti");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("\tBefore test calisti");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("\tAfter test calisti");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\tBefore class calisti");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\t\tAfter class calisti");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\tBefore method calisti");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("\t\t\tAfter method calisti");
    }

}
