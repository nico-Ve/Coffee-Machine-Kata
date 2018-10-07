package protocolTest;

import coffee.machine.kata.DrinkMakerProtocol;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class DrinkMakerProtocolTest {

    private static DrinkMakerProtocol dmp;

    public DrinkMakerProtocolTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dmp = new DrinkMakerProtocol();
    }    

    @Test
    public void DrinkMakerProtocol_oneDrinkOneSugar_ExpectedStringFormat() {
        String result = dmp.order("tea", 1);
        assertEquals("T:1:0", result);
    }

    @Test
    public void DrinkMakerProtocol_oneDrinkNoSugar_ExpectedStringFormat() {
        String result = dmp.order("chocolate", 0);
        assertEquals("H::", result);
    }

    @Test
    public void DrinkMakerProtocol_oneDrinkMoreThanTwoSugar_ExpectedStringFormat() {
        String result = dmp.order("coffee", 3);
        assertEquals("C:2:0", result);
    }

    @Test
    public void DrinkMakerProtocol_message_ExpectedStringFormat() {
        String content = "message content";
        String result = dmp.sendMessage(content);
        assertEquals("M:" + content, result);
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
