package clarusway.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {

    public static String getScreensShot(WebDriver driver,String name) throws IOException {

        String date=formatCurrentDate("yyyyMMddhhss");//scren shot dosya ismi için şuanki tarihi string olarak alıyoruz.

        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//cast işlemi yaptık,ss alıp file obj atıyoruz

        String target = System.getProperty("user.dir")+"/test-output/Screenshots/"+name+date+".png";

        File targetFile=new File(target);

        FileUtils.copyFile(source,targetFile);

        return  target;

    }

    public static String formatCurrentDate(String pattern){

        return new SimpleDateFormat(pattern).format(new Date());
    }
}
