package tests;

import base.UIBaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends UIBaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");
    }


}
