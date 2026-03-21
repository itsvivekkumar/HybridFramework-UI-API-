package base;

import utils.ConfigRead;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigRead.getBaseUrl();
    }

}
