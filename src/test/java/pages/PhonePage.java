package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.PhonePageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhonePage {
    PhonePageObject phonePageObject;
    WebDriver driver;

    public PhonePage(WebDriver driver) {
        phonePageObject = new PhonePageObject(driver);
        this.driver = driver;
    }

    List<String> arrayList = new ArrayList<String>();

    public void getMaximumPriceOfPhone() {
        phonePageObject.phoneLink.click();
        List<WebElement> prices = phonePageObject.phonesPrices;
        for (WebElement element : prices) {
            arrayList.add(element.getText().replace("$", ""));
        }
        Collections.sort(arrayList);
        System.out.println("Maximum price of phone =" + arrayList.get(arrayList.size() - 1));
    }
}
