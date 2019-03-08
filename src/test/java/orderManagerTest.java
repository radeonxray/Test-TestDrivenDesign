import org.junit.jupiter.api.*;
import java.sql.Timestamp;
import java.util.ArrayList;

class orderManagerTest {

    private OrderManager orderManager;

    private CustomerOrder customerOrder1;
    private CustomerOrder customerOrder2;
    private CustomerOrder customerOrder3;
    private CustomerOrder customerOrder4;
    private CustomerOrder customerOrder5;
    private CustomerOrder customerOrder6;

    private Timestamp firstOrderTimeStamp;
    private Timestamp secondOrderTimeStamp;
    private Timestamp thirdOrderTimeStamp;
    private Timestamp fourthOrderTimeStamp;
    private Timestamp fifthOrderTimeStamp;
    private Timestamp sixthOrderTimeStamp;

    private ArrayList<Item> items;
    private ArrayList<Item> items2;
    private ArrayList<Item> items3;
    private ArrayList<Item> items4;
    private ArrayList<Item> items5;
    private ArrayList<Item> items6;

    //Setup the test environment before EACH test
    @BeforeEach
    public void testSetup() throws InterruptedException {

        setupOrderItems();
        setupTimeStamps();

        orderManager = new OrderManager();

        setupCustomerOrders();
    }

    //Clear all ArrayList containing Customer Orders, after each test
    @AfterEach
    public void testAfterAll(){
        orderManager.clearAllList();
    }

    //Method to setup the Customer Order Items
    public void setupOrderItems(){
        items = new ArrayList<Item>();
        items.add(new Item(1, "1", 61f));
        items.add(new Item(2, "8", 61f));
        items.add(new Item(3,"9", 61f));

        items2 = new ArrayList<Item>();
        items2.add(new Item(1, "6", 61f));
        items2.add(new Item(2, "15", 61f));
        items2.add(new Item(3,"9", 61f));

        items3 = new ArrayList<Item>();
        items3.add(new Item(1, "1", 61f));
        items3.add(new Item(2, "8", 61f));
        items3.add(new Item(3,"9", 61f));
        items3.add(new Item(4,"9", 61f));
        items3.add(new Item(5,"9", 61f));

        items4 = new ArrayList<Item>();
        items4.add(new Item(1, "8", 61f));
        items4.add(new Item(2, "6", 61f));
        items4.add(new Item(3,"2", 61f));
        items4.add(new Item(3,"2", 61f));

        items5 = new ArrayList<Item>();
        items5.add(new Item(1, "1", 61f));

        items6 = new ArrayList<Item>();
        items6.add(new Item(1, "1", 61f));
        items6.add(new Item(2, "8", 61f));
        items6.add(new Item(3,"9", 61f));
        items6.add(new Item(3,"9", 61f));
        items6.add(new Item(3,"9", 61f));
        items6.add(new Item(3,"9", 61f));
        items6.add(new Item(3,"9", 61f));
    }


    //Method to setup the TimeStamps for each customerOrder
    //Thread.sleep because if run without, the times might be set incorrectly depending on the Hardware
    private void setupTimeStamps() throws InterruptedException {

        Thread.sleep(1000);

        firstOrderTimeStamp = new Timestamp(System.currentTimeMillis());
        customerOrder1 = new CustomerOrder(items);

        Thread.sleep(500);

        secondOrderTimeStamp = new Timestamp(System.currentTimeMillis());
        customerOrder2 = new CustomerOrder(items2);

        Thread.sleep(500);
        thirdOrderTimeStamp = new Timestamp(System.currentTimeMillis());
        customerOrder3 = new CustomerOrder(items3);

        Thread.sleep(500);
        fourthOrderTimeStamp = new Timestamp(System.currentTimeMillis());
        customerOrder4 = new CustomerOrder(items4);

        Thread.sleep(500);
        fifthOrderTimeStamp = new Timestamp(System.currentTimeMillis());
        customerOrder5 = new CustomerOrder(items5);

        Thread.sleep(500);
        sixthOrderTimeStamp = new Timestamp(System.currentTimeMillis());
        customerOrder6 = new CustomerOrder(items6);
    }

    //Method to assign the various customerItems to customerOrders
    public void setupCustomerOrders(){

        orderManager.newOrder(customerOrder1);
        orderManager.newOrder(customerOrder2);
        orderManager.newOrder(customerOrder3);
        orderManager.newOrder(customerOrder4);
        orderManager.newOrder(customerOrder5);
        orderManager.newOrder(customerOrder6);
    }

    //Test that the OrderManager has 1 customerOrder within it
    @Test
    public void testOrderManagerIsNotEmpty(){

        orderManager.clearAllList();
        orderManager.newOrder(customerOrder1);
        Assertions.assertEquals( 1,orderManager.size());
    }

    //Test that the OrderManager is empty
    @Test
    public void testOrderManagerIsEmpty(){

        orderManager.clearAllList();
        Assertions.assertEquals( 0,orderManager.size());
    }

    //Test that the printOrderList-method displays the correct information
    @Test
    public void testOrderManagerPrint(){

        orderManager.clearAllList();
        orderManager.newOrder(customerOrder1);
        Assertions.assertEquals("1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: New | Ordered: " + firstOrderTimeStamp + "\n", orderManager.printFilteredOrdersList(CustomerOrder.Status.New));
    }


    //Test that the printOrderList-method displays the correct information with multiple orders with new status
    @Test
    public void testPrintMultipleOrders_WithStatusNew() throws InterruptedException {

        Assertions.assertEquals(
                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: New | Ordered: " + firstOrderTimeStamp + "\n" +

        "1 - Item: 6 / 2 - Item: 15 / 3 - Item: 9 /  | Status: New | Ordered: " + secondOrderTimeStamp + "\n" +
        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 4 - Item: 9 / 5 - Item: 9 /  | Status: New | Ordered: "+ thirdOrderTimeStamp + "\n" +
        "1 - Item: 8 / 2 - Item: 6 / 3 - Item: 2 / 3 - Item: 2 /  | Status: New | Ordered: "  + fourthOrderTimeStamp + "\n" +
        "1 - Item: 1 /  | Status: New | Ordered: "  + fifthOrderTimeStamp + "\n" +
        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 /  | Status: New | Ordered: "  + sixthOrderTimeStamp + "\n"
                , orderManager.printFilteredOrdersList(CustomerOrder.Status.New));
    }

    //Test that the printOrderList-method displays the correct information with multiple new orders
    @Test
    public void testPrintMultipleOrders_WithVariousStatus() throws InterruptedException {

        orderManager.getOrderFromCurrentOrderList(customerOrder1).setStatus(CustomerOrder.Status.PickedUp);
        orderManager.getOrderFromCurrentOrderList(customerOrder2).setStatus(CustomerOrder.Status.PickedUp);
        orderManager.getOrderFromCurrentOrderList(customerOrder3).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder4).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder5).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder6).setStatus(CustomerOrder.Status.New);

        Assertions.assertEquals(
                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + firstOrderTimeStamp + "\n" +
                        "1 - Item: 6 / 2 - Item: 15 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + secondOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 4 - Item: 9 / 5 - Item: 9 /  | Status: ReadyForPickup | Ordered: "+ thirdOrderTimeStamp + "\n" +
                        "1 - Item: 8 / 2 - Item: 6 / 3 - Item: 2 / 3 - Item: 2 /  | Status: ReadyForPickup | Ordered: "  + fourthOrderTimeStamp + "\n" +
                        "1 - Item: 1 /  | Status: ReadyForPickup | Ordered: "  + fifthOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 /  | Status: New | Ordered: "  + sixthOrderTimeStamp + "\n"
                , orderManager.printAllCurrentOrders());
    }

    //Test to see if orders are removed from the currentOrder1ist and added to the removedOrderList.
    @Test
    public void testRemoveOrder() throws InterruptedException {


        //Check and Assert that the orders have been created and are in the currentOrderList
        Assertions.assertEquals(
                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: New | Ordered: " + firstOrderTimeStamp + "\n" +
                        "1 - Item: 6 / 2 - Item: 15 / 3 - Item: 9 /  | Status: New | Ordered: " + secondOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 4 - Item: 9 / 5 - Item: 9 /  | Status: New | Ordered: "+ thirdOrderTimeStamp + "\n" +
                        "1 - Item: 8 / 2 - Item: 6 / 3 - Item: 2 / 3 - Item: 2 /  | Status: New | Ordered: "  + fourthOrderTimeStamp + "\n" +
                        "1 - Item: 1 /  | Status: New | Ordered: "  + fifthOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 /  | Status: New | Ordered: "  + sixthOrderTimeStamp + "\n"
                , orderManager.printAllCurrentOrders());


        orderManager.getOrderFromCurrentOrderList(customerOrder1).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder1).setStatus(CustomerOrder.Status.PickedUp);
        orderManager.getOrderFromCurrentOrderList(customerOrder2).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder2).setStatus(CustomerOrder.Status.PickedUp);

        orderManager.removeOrder(customerOrder1);
        orderManager.removeOrder(customerOrder2);

        orderManager.getOrderFromCurrentOrderList(customerOrder3).setStatus(CustomerOrder.Status.PickedUp);
        orderManager.getOrderFromCurrentOrderList(customerOrder4).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder5).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder6).setStatus(CustomerOrder.Status.New);

        //Check and Assert that the removed Orders are no longer in the currentOrderList
        Assertions.assertEquals(

                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 4 - Item: 9 / 5 - Item: 9 /  | Status: PickedUp | Ordered: "+ thirdOrderTimeStamp + "\n" +
                        "1 - Item: 8 / 2 - Item: 6 / 3 - Item: 2 / 3 - Item: 2 /  | Status: ReadyForPickup | Ordered: "  + fourthOrderTimeStamp + "\n" +
                        "1 - Item: 1 /  | Status: ReadyForPickup | Ordered: "  + fifthOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 /  | Status: New | Ordered: "  + sixthOrderTimeStamp + "\n"
                , orderManager.printAllCurrentOrders());

        //Check and Assert that the removedOrdersList contains the orders that was removed from the currentOrderList
        Assertions.assertEquals(
                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + firstOrderTimeStamp + "\n" +
                        "1 - Item: 6 / 2 - Item: 15 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + secondOrderTimeStamp + "\n"
                ,orderManager.printAllRemovedOrders());
    }

    //Test to check if ALL the customer orders, from both the currentOrderList and removedOrderList, are present in the AllTodaysOrderList
    @Test
    public void testPrintAllTodaysOrders() throws InterruptedException {

        //Check and Assert that the orders have been created and are in the currentOrderList
        Assertions.assertEquals(
                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: New | Ordered: " + firstOrderTimeStamp + "\n" +
                        "1 - Item: 6 / 2 - Item: 15 / 3 - Item: 9 /  | Status: New | Ordered: " + secondOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 4 - Item: 9 / 5 - Item: 9 /  | Status: New | Ordered: "+ thirdOrderTimeStamp + "\n" +
                        "1 - Item: 8 / 2 - Item: 6 / 3 - Item: 2 / 3 - Item: 2 /  | Status: New | Ordered: "  + fourthOrderTimeStamp + "\n" +
                        "1 - Item: 1 /  | Status: New | Ordered: "  + fifthOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 /  | Status: New | Ordered: "  + sixthOrderTimeStamp + "\n"
                , orderManager.printAllCurrentOrders());


        orderManager.getOrderFromCurrentOrderList(customerOrder1).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder1).setStatus(CustomerOrder.Status.PickedUp);
        orderManager.getOrderFromCurrentOrderList(customerOrder2).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder2).setStatus(CustomerOrder.Status.PickedUp);

        orderManager.removeOrder(customerOrder1);
        orderManager.removeOrder(customerOrder2);

        orderManager.getOrderFromCurrentOrderList(customerOrder3).setStatus(CustomerOrder.Status.PickedUp);
        orderManager.getOrderFromCurrentOrderList(customerOrder4).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder5).setStatus(CustomerOrder.Status.ReadyForPickup);
        orderManager.getOrderFromCurrentOrderList(customerOrder6).setStatus(CustomerOrder.Status.New);

        //Check and Assert that the removed Orders are no longer in the currentOrderList
        Assertions.assertEquals(

                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 4 - Item: 9 / 5 - Item: 9 /  | Status: PickedUp | Ordered: "+ thirdOrderTimeStamp + "\n" +
                        "1 - Item: 8 / 2 - Item: 6 / 3 - Item: 2 / 3 - Item: 2 /  | Status: ReadyForPickup | Ordered: "  + fourthOrderTimeStamp + "\n" +
                        "1 - Item: 1 /  | Status: ReadyForPickup | Ordered: "  + fifthOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 /  | Status: New | Ordered: "  + sixthOrderTimeStamp + "\n"
                , orderManager.printAllCurrentOrders());

        //Check and Assert that the removedOrdersList contains the orders that was removed from the currentOrderList
        Assertions.assertEquals(
                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + firstOrderTimeStamp + "\n" +
                        "1 - Item: 6 / 2 - Item: 15 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + secondOrderTimeStamp + "\n"
                ,orderManager.printAllRemovedOrders());

        //Check and Assert that AllTodaysOrders contains both the current- and removed-orders
        Assertions.assertEquals(
                "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 4 - Item: 9 / 5 - Item: 9 /  | Status: PickedUp | Ordered: "+ thirdOrderTimeStamp + "\n" +
                        "1 - Item: 8 / 2 - Item: 6 / 3 - Item: 2 / 3 - Item: 2 /  | Status: ReadyForPickup | Ordered: "  + fourthOrderTimeStamp + "\n" +
                        "1 - Item: 1 /  | Status: ReadyForPickup | Ordered: "  + fifthOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 / 3 - Item: 9 /  | Status: New | Ordered: "  + sixthOrderTimeStamp + "\n" +
                        "1 - Item: 1 / 2 - Item: 8 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + firstOrderTimeStamp + "\n" +
                        "1 - Item: 6 / 2 - Item: 15 / 3 - Item: 9 /  | Status: PickedUp | Ordered: " + secondOrderTimeStamp + "\n"
                ,orderManager.printAllTodaysOrders()
        );


    }

}