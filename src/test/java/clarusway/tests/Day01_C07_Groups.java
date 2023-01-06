package clarusway.tests;

import org.testng.annotations.Test;

public class Day01_C07_Groups {

    // Bu groups attribute u sayesinde biz istedigimiz grouplara sahip test caselerini ozel olarak calistirabiliriz.
    // testlerimizi işratledik gibi bir şey.(sarışın esmer gibi) login test gibi de eklenebilir. yada fonsiyonuyla ilgili
    //smoke testlerin hepsinin geçmesi lazım insta nın login fonk smoke mesela geçmesi lazım
    //regression o zamana kadar yazmış olduğumuz testlerin yeniden koşulması,canlıya çıkmadan önceki son hali gibi
    // kalan test geçen testlerin bakıp incelenmesi gibi regression

    @Test(groups = {"smoke", "regression"})
    public void loginTest(){

    }

    @Test(groups = {"regression"})
    public void aboutTest(){

    }

    @Test(groups = {"regression"})
    public void contactTest(){

    }

    @Test(groups = {"regression", "smoke"})
    public void registrationTest(){

    }

    @Test(groups = {"regression", "smoke"})
    public void checkoutTest(){

    }

}