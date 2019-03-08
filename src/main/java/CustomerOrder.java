import sun.util.calendar.BaseCalendar;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

public class CustomerOrder implements CustomerOrderInterface{

    private ArrayList<Item> items;
    private Status status;
    private Timestamp orderTimeStamp;


    public enum Status{
        New,
        ReadyForPickup,
        PickedUp

    }

    public CustomerOrder(ArrayList<Item> items){
        this.items = items;
        this.status = Status.New;
        this.orderTimeStamp = new Timestamp(System.currentTimeMillis());

    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getOrderTimeStamp() {
        return orderTimeStamp;
    }


}
