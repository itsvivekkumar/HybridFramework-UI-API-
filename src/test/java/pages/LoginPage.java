package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPageObject;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginPage {

    private LoginPageObject loginPageObject;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.loginPageObject = new LoginPageObject(driver);
        wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
    }

    public void login(String userName, String pass) throws InterruptedException {
        loginPageObject.loginLnk.click();
        Thread.sleep(2000);
        loginPageObject.userName.sendKeys(userName);
        loginPageObject.userPass.sendKeys(pass);
        loginPageObject.loginBtn.click();
//        Thread.sleep(2000);
        String txt = wait.until(ExpectedConditions.visibilityOf(loginPageObject.welcomText)).getText();
        if (txt.equalsIgnoreCase("Welcome " + userName)) {
            System.out.println("Login sucess---------");
        } else {
            System.out.println("Failed t0 login===");
        }

    }

}
