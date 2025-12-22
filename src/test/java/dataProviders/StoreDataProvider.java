package dataProviders;

import org.testng.annotations.DataProvider;
import pojo.StorePayload;

public class StoreDataProvider {


    //this method can be any class/also can excel file. Impt thing is we need to connect this method to Test(),
    //also accept as parameter whatever data provider method returns  .
    @DataProvider(name = "storeOrderData")
    public static Object[][] getStoreOrderData() {

        StorePayload storePayload = new StorePayload();
        storePayload.setId(10);
        storePayload.setPetId(1);
        storePayload.setQuantity(0);
        storePayload.setShipDate("2025-12-22T09:38:54.295Z");
        storePayload.setStatus("placed");
        storePayload.setComplete(true);

//        StorePayload order2 = new StorePayload();
//        order2.setId(11);
//        order2.setPetId(2);
//        order2.setQuantity(3);
//        order2.setShipDate("2025-12-23T10:20:00.000Z");
//        order2.setStatus("approved");
//        order2.setComplete(false);

        return new Object[][] {
                { storePayload }
//                { order2 }
        };
    }
}
