package clarusway.tests;

import org.testng.annotations.DataProvider;

public class Day03_C03_DataProviderClass {

    @DataProvider(name="testData")
    public Object[][] data(){
        Object[][] returnData={
                {"First test","birinci test"},
                {"Second test","ikinci test"},
                {"Third test","üçüncü test"}
        };

        return returnData;
    }
}
