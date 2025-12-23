package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class UIBaseTest {
    protected WebDriver driver;

    @BeforeMethod      //this works before every Test()
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/");
    }

    @AfterMethod                  //this works after every Test()
    public void tearDown() {
        driver.quit();
    }
}
