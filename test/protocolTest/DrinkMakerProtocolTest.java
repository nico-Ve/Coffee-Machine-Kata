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
      
    @Before
    public void setUp() {
        dmp = new DrinkMakerProtocol();
    }
    
    // Iteration 1 tests
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
    
    
    // Iteration 2 tests
    @Test
    public void DrinkMakerProtocol_oneDrinkNotEnoughMoney_ExpectedMessageSend() {
        float money = 0.1f;
        dmp.insertMoney(money);
        String result = dmp.order("tea", 1);
        assertEquals("0.3 missing", result);
    }
    
    @Test
    public void DrinkMakerProtocol_oneDrinkEnoughMoney_ExpectedOrderTaken() {
        float money = 1.65f;
        dmp.insertMoney(money);
        String result = dmp.order("coffee", 0);
        assertEquals("C::", result);
    }
    
    

    @BeforeClass
    public static void setUpClass() {}    
  
    @AfterClass
    public static void tearDownClass() {}

    @After
    public void tearDown() {}
}
