import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.ArrayList;

class CustomerOrderTest {

    private CustomerOrder customerOrder;
    private Timestamp firstOrderTimeStamp;

    @BeforeEach
    public void testSetup(){

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(1, "1", 61f));
        items.add(new Item(2, "8", 61f));
        items.add(new Item(3,"9", 61f));

        customerOrder = new CustomerOrder(items);
        firstOrderTimeStamp = new Timestamp(System.currentTimeMillis());

    }

    //Test that the default status when creating a new customerOrder is set to New
    @Test
    public void testDefaultStatus(){

        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(new Item(1, "8", 61f));
        items2.add(new Item(2, "9", 61f));
        items2.add(new Item(3,"13", 61f));

        customerOrder = new CustomerOrder(items2);

        Assertions.assertEquals(CustomerOrder.Status.New, customerOrder.getStatus());
    }

    //Test that the first orders timestamp is correct
    @Test
    public void testOrderTimeStamp() throws InterruptedException {

        Thread.sleep(5000);

        Assertions.assertEquals(firstOrderTimeStamp, customerOrder.getOrderTimeStamp());
    }

    //Test that 2 orders have their own individual and correct timestamps
    @Test
    public void testNewOrderTimeStamp() throws InterruptedException {

        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(new Item(1, "4", 61f));
        items2.add(new Item(2, "2", 61f));
        items2.add(new Item(3,"9", 61f));
        items2.add(new Item(4,"12", 61f));

        Thread.sleep(2000);

        CustomerOrder customerOrder2 = new CustomerOrder(items2);

        Timestamp secondOrderTimeStamp = new Timestamp(System.currentTimeMillis());

        //Stop time to avoid testing asap after the timestamps has been set
        Thread.sleep(4000);

        Assertions.assertEquals(secondOrderTimeStamp, customerOrder2.getOrderTimeStamp());
    }

    //Test to check that multiple Orders have their own individual and correct time stamp
    @Test
    public void testMultipleOrderTimeStamps() throws InterruptedException{

        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(new Item(1, "4", 61f));
        items2.add(new Item(2, "2", 61f));
        items2.add(new Item(3,"9", 61f));
        items2.add(new Item(4,"12", 61f));

        Thread.sleep(3000);

        CustomerOrder customerOrder2 = new CustomerOrder(items2);

        Timestamp secondOrderTimeStamp = new Timestamp(System.currentTimeMillis());

        //Stop time to avoid testing asap after the timestamps has been set
        Thread.sleep(3000);

        ArrayList<Item> items3 = new ArrayList<Item>();
        items2.add(new Item(1, "4", 61f));
        items2.add(new Item(2, "2", 61f));
        items2.add(new Item(3,"9", 61f));
        items2.add(new Item(4,"12", 61f));

        CustomerOrder customerOrder3 = new CustomerOrder(items3);

        Timestamp thirdOrderTimeStamp = new Timestamp(System.currentTimeMillis());

        //Stop time to avoid testing asap after the timestamps has been set
        Thread.sleep(3000);

        //Check that TimeStamps for each customerOrder are correct
        Assertions.assertEquals(firstOrderTimeStamp, customerOrder.getOrderTimeStamp());
        Assertions.assertEquals(secondOrderTimeStamp, customerOrder2.getOrderTimeStamp());
        Assertions.assertEquals(thirdOrderTimeStamp, customerOrder3.getOrderTimeStamp());
    }

    //Test that the customerOrder status is set to New
    @Test
    public void testOrderStatus_New(){

        Assertions.assertEquals(CustomerOrder.Status.New, customerOrder.getStatus());
    }

    //Test that the customerOrder status can be correctly set to "ReadyForPickUp"
    @Test
    public void testChangeOrderStatus_ReadyForPickup(){

        customerOrder.setStatus(CustomerOrder.Status.ReadyForPickup);
        Assertions.assertEquals(CustomerOrder.Status.ReadyForPickup, customerOrder.getStatus());
    }

    //Test that the customerOrder status can be correctly set to "PickedUp"
    @Test
    public void testChangeOrderStatus_PickedUp(){

        customerOrder.setStatus(CustomerOrder.Status.PickedUp);
        Assertions.assertEquals(CustomerOrder.Status.PickedUp, customerOrder.getStatus());
    }

    //Test to check that an customerOrder goes through all possible status
    @Test
    public void testChainOfOrderStatus(){

        Assertions.assertEquals(CustomerOrder.Status.New, customerOrder.getStatus());

        customerOrder.setStatus(CustomerOrder.Status.ReadyForPickup);
        Assertions.assertEquals(CustomerOrder.Status.ReadyForPickup, customerOrder.getStatus());

        customerOrder.setStatus(CustomerOrder.Status.PickedUp);
        Assertions.assertEquals(CustomerOrder.Status.PickedUp, customerOrder.getStatus());
    }

    //Test that items match what is created in the customerOrder
    @Test
    public void testOrderItems(){

        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(new Item(1, "1", 61f));
        items2.add(new Item(2, "8", 61f));
        items2.add(new Item(3,"9", 61f));

        CustomerOrder customerOrder2 = new CustomerOrder(items2);

        Assertions.assertEquals(items2.get(0), customerOrder2.getItems().get(0) );
        Assertions.assertEquals(items2.get(1), customerOrder2.getItems().get(1) );
        Assertions.assertEquals(items2.get(2), customerOrder2.getItems().get(2) );
        Assertions.assertEquals(timeStamp, customerOrder2.getOrderTimeStamp());
    }



}