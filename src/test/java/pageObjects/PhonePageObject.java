package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PhonePageObject {
    public PhonePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Phones')]")
    public WebElement phoneLink;
    @FindBy(xpath = "//div[@id='tbodyid']//following::h5")
    public List<WebElement> phonesPrices;

    @FindBy(xpath = "//input[@id='loginpassword']")
    public WebElement a;

}
