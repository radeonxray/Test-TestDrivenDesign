import java.util.ArrayList;

public class OrderManager implements OrderManagerInterface {

    private ArrayList<CustomerOrder> currentCustomerOrderList;
    private ArrayList<CustomerOrder> removedCustomerOrderList;
    private ArrayList<CustomerOrder> allTodaysCustomerOrderList;


    public OrderManager(){
        currentCustomerOrderList = new ArrayList<CustomerOrder>();
        removedCustomerOrderList = new ArrayList<CustomerOrder>();
        allTodaysCustomerOrderList = new ArrayList<CustomerOrder>();
    }

    public ArrayList<CustomerOrder> getRemovedCustomerOrderList() {
        return removedCustomerOrderList;
    }

    public ArrayList<CustomerOrder> getCurrentCustomerOrderList() {
        return currentCustomerOrderList;
    }

    public ArrayList<CustomerOrder> getAllTodaysCustomerOrderList() {
        return allTodaysCustomerOrderList;
    }

    public void newOrder(CustomerOrder customerOrder){
        currentCustomerOrderList.add(customerOrder);

    }

    public void clearAllList(){
        getCurrentCustomerOrderList().clear();
        getRemovedCustomerOrderList().clear();
        getAllTodaysCustomerOrderList().clear();
    }

    public CustomerOrder getOrderFromCurrentOrderList(CustomerOrder customerOrder){
       for(CustomerOrder customerOrderInList : currentCustomerOrderList){
           if(customerOrderInList.getOrderTimeStamp().equals(customerOrder.getOrderTimeStamp())){
               return customerOrderInList;
           }
       }

        return customerOrder;
    }


    public String printFilteredOrdersList(CustomerOrder.Status filter){
        String output =  "";

        for (CustomerOrder customerOrder : currentCustomerOrderList) {

            if (customerOrder.getStatus() != filter)
                continue;
            for (Item item : customerOrder.getItems()) {
                output += item.getId() + " - Item: " + item.getText() + " / "  ;
            }
            output += " | Status: " + customerOrder.getStatus() + " | Ordered: " + customerOrder.getOrderTimeStamp() + "\n"   ;

        }
        return  output;
    }

    public String printAllCurrentOrders(){
        String output =  "";

        for (CustomerOrder customerOrder : currentCustomerOrderList) {

            for (Item item : customerOrder.getItems()) {
                output += item.getId() + " - Item: " + item.getText() + " / "  ;
            }
            output += " | Status: " + customerOrder.getStatus() + " | Ordered: " + customerOrder.getOrderTimeStamp() + "\n"   ;

        }
        return  output;
    }

    public String printAllRemovedOrders(){
        String output =  "";

        for (CustomerOrder customerOrder : removedCustomerOrderList) {

            for (Item item : customerOrder.getItems()) {
                output += item.getId() + " - Item: " + item.getText() + " / "  ;
            }
            output += " | Status: " + customerOrder.getStatus() + " | Ordered: " + customerOrder.getOrderTimeStamp() + "\n"   ;

        }
        return  output;
    }

    public int size() {
        return currentCustomerOrderList.size();
    }

    public void removeOrder(CustomerOrder customerOrder) {
        removedCustomerOrderList.add(customerOrder);
        currentCustomerOrderList.remove(customerOrder);
    }

    public String printAllTodaysOrders(){
        allTodaysCustomerOrderList.addAll(getCurrentCustomerOrderList());
        allTodaysCustomerOrderList.addAll(getRemovedCustomerOrderList());

        String output =  "";

        for (CustomerOrder customerOrder : allTodaysCustomerOrderList) {

            for (Item item : customerOrder.getItems()) {
                output += item.getId() + " - Item: " + item.getText() + " / "  ;
            }
            output += " | Status: " + customerOrder.getStatus() + " | Ordered: " + customerOrder.getOrderTimeStamp() + "\n"   ;
        }
        return  output;
    }

}
