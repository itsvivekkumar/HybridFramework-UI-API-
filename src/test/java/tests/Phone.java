package tests;

import base.UIBaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PhonePage;

public class Phone extends UIBaseTest {

    @Test
    public void maximumPriceOfPhone() throws InterruptedException {
        LoginPage l = new LoginPage(driver);
        l.login("admin", "admin");
        PhonePage phonePage = new PhonePage(driver);
        phonePage.getMaximumPriceOfPhone();
    }

}
