public interface OrderManagerInterface {

    void newOrder(CustomerOrder customerOrder);
    void clearAllList();
    CustomerOrder getOrderFromCurrentOrderList(CustomerOrder customerOrder);
    String printFilteredOrdersList(CustomerOrder.Status filter);
    String printAllCurrentOrders();
    String printAllRemovedOrders();
    int size();
    void removeOrder(CustomerOrder customerOrder) ;
    String printAllTodaysOrders();

}
