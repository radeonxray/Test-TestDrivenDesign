import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MockitoTest {

    @Mock
    ItemInterface itemInterface;

    @Mock
    CustomerOrderInterface coi;

    @Mock
    OrderManagerInterface omi;

    @Test
    public void itemMockitoTest(){

        when(itemInterface.getId()).thenReturn(1);
        when(itemInterface.getPrice()).thenReturn(90f);
        when(itemInterface.getText()).thenReturn("23");


    }

    @Test
    public void customOrderMockitoTest(){
        ArrayList<Item> item1 = new ArrayList<Item>();
        item1.add(new Item(1,"text11",50f));
        item1.add(new Item(2,"text23",20f));

        when(coi.getItems()).thenReturn(item1);

        coi.getItems();
        coi.getStatus();
        coi.getOrderTimeStamp();
        coi.setStatus(CustomerOrder.Status.ReadyForPickup);

        verify(coi, atLeastOnce()).getItems();
        verify(coi, times(1)).getStatus();
        verify(coi, atLeast(1)).getOrderTimeStamp();
        verify(coi, atMost(1)).setStatus(CustomerOrder.Status.ReadyForPickup);
    }

    @Test
    public void orderManagerMockitoTest(){

        when(omi.size()).thenReturn(3);
    }




}