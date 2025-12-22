package dataProviders;

import org.testng.annotations.DataProvider;
import pojo.UserPayload;

import java.util.List;

public class UserDataProvider {

    @DataProvider(name = "userClassData")
    public static Object[][] getStoreOrderData() {

        UserPayload userPayload = new UserPayload();
        userPayload.setId(1);
        userPayload.setUsername("edj123");
        userPayload.setFirstName("Edward");
        userPayload.setLastName("Yadav");
        userPayload.setEmail("edj@example.com");
        userPayload.setPassword("edj@123");
        userPayload.setPhone("9843212300");
        userPayload.setUserStatus(100);

        List<UserPayload> userPayloads=List.of(userPayload);

        return new Object[][] {
                {userPayloads}
        };
    }
}
