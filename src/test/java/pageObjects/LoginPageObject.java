package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

    public LoginPageObject(WebDriver driver) {
        System.out.println("D----"+driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(text(),'Log in')]")  public WebElement loginLnk;
    @FindBy(xpath = "//input[@id='loginusername']") public WebElement userName;
    @FindBy(xpath = "//input[@id='loginpassword']") public WebElement userPass;
    @FindBy(xpath = "//button[contains(text(),'Log in')]") public WebElement loginBtn;
    @FindBy(xpath = "//a[contains(text(),'Welcome admin')]") public WebElement welcomText;


//    public static final By LoginLnk= By.xpath("//a[contains(text(),'Log in')]");
//    public static final By = By.xpath("");
//    public static final By = By.xpath("");
//    public static final By = By.xpath("");
//    public static final By = By.xpath("");

}
