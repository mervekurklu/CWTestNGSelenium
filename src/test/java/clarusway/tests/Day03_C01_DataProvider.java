package clarusway.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day03_C01_DataProvider {//aynı testi birden fazla sonucu veren test durumlarında kullanıyoruz sadece data değiştirerek bakıyoruz

    @Test(dataProvider = "dataProvider")
    public void test01(String name) {
        //verileri dataprovider methodundan alarak calışılacak olan test
        System.out.println(name);
    }


    @DataProvider
    public Object[][] dataProvider(){
        //verileri teste sağlayacak olan method
        Object[][] data={
                {"merve"},
                {"yldrm"},
                {"Clarusway"}
        };


        return data;
    }
}
