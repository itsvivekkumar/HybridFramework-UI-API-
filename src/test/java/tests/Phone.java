package tests;

import base.UIBaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PhonePage;

import java.io.IOException;

public class Phone extends UIBaseTest {

    @Test
    public void maximumPriceOfPhone() throws InterruptedException, IOException {
        LoginPage l = new LoginPage(driver);
        l.login("admin", "admin");
        PhonePage phonePage = new PhonePage(driver);
        phonePage.getMaximumPriceOfPhone();


        //Remember need to delete below code and also exception added at method level
//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String path= System.getProperty("user.dir")+"/screenshots/test.png";
//        File dest=new File(path);
//        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}
