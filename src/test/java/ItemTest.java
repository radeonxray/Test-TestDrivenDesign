import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnitPlatform.class)
class ItemTest {

    Item newItem;

    @BeforeEach
    public void setUp()
    {
         newItem = new Item(1,"30",89f);
    }

    @Test
    public void newItemIdTest(){
        int id = 1;
        assertEquals(id, newItem.getId());
    }

    @Test
    public void newItemDescriptionTest(){
        String description = "30";
        assertEquals(description, newItem.getText());
    }

    @Test
    public void newItemPriceTest(){
        float price = 89f;
        assertEquals(price, newItem.getPrice());
    }



}