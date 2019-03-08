import java.sql.Timestamp;
import java.util.ArrayList;

public interface CustomerOrderInterface {

    ArrayList<Item> getItems();
    CustomerOrder.Status getStatus();
    void setStatus(CustomerOrder.Status status);
    Timestamp getOrderTimeStamp();
}
