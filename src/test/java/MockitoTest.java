import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MockitoTest {

    @Mock
    ItemInterface itemInterface;

    @Test
    public void itemMockitoTest(){

        when(itemInterface.getId()).thenReturn(1);
        when(itemInterface.getPrice()).thenReturn(90f);
        when(itemInterface.getText()).thenReturn("23");

    }




}