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
        dmp.setMoney(1.65f);
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
        dmp.setMoney(0.1f);
        String result = dmp.order("tea", 1);
        assertEquals("M:0.3 missing", result);
    }   
    
    @Test
    public void DrinkMakerProtocol_oneDrinkEnoughMoney_ExpectedMoneyWithdraw() {
        dmp.order("chocolate", 0);
        float result = dmp.getMoney();
        assertEquals(1.15f, result, 0);
    }
    
    

    @BeforeClass
    public static void setUpClass() {}    
  
    @AfterClass
    public static void tearDownClass() {}

    @After
    public void tearDown() {}
}
