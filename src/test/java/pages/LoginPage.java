package pages;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;

public class LoginPage {

    private LoginPageObject loginPageObject;

    public LoginPage(WebDriver driver) {
        this.loginPageObject = new LoginPageObject(driver);
    }

    public void login(String userName, String pass) throws InterruptedException {
        loginPageObject.loginLnk.click();
        Thread.sleep(2000);
        loginPageObject.userName.sendKeys(userName);
        loginPageObject.userPass.sendKeys(pass);
        loginPageObject.loginBtn.click();
        Thread.sleep(2000);
        String txt= loginPageObject.welcomText.getText();
        if (txt.equalsIgnoreCase("Welcome "+userName)){
            System.out.println("Login sucess---------");
        }else {
            System.out.println("Failed t0 login===");
        }

    }

}
