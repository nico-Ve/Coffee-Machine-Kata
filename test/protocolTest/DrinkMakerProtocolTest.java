package protocolTest;

import coffee.machine.kata.Drink;
import coffee.machine.kata.DrinkMakerProtocol;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

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
        dmp.getOptions().put("tea", new Drink("T", 0.4f));
        dmp.getOptions().put("chocolate", new Drink("H", 0.5f));
        dmp.getOptions().put("coffee", new Drink("C", 0.6f));
        dmp.getOptions().put("orange", new Drink("O", 0.6f, false, false));
        dmp.setReportingRepository();
        dmp.setMessageCode("M");
        dmp.setExtraHotCode("h");
        dmp.setSeparator(":");
        dmp.setMoney(1.65f);
        dmp.setBeverageQuantityChecker(new MockingBeverageQuantityChecker());
        dmp.setEmailNotifier(new MockingEmailNotifier());
    }

    
    // Iteration 1 tests--------------------------------------------------------
    @Test
    public void DrinkMakerProtocol_oneDrinkOneSugar_ExpectedStringFormat() {
        String result = dmp.order("tea", 1);
        assertEquals("T:1:0", result);
    }

    @Test @Ignore
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
    
    @Test
    public void DrinkMakerProtocol_invaldDrinkAttempt_ExpectedNotAvailableMessage() {        
        String result = dmp.order("coca cola", 0);
        assertEquals("M:no drink available", result);
    }

    
    // Iteration 2 tests--------------------------------------------------------
    @Test
    public void DrinkMakerProtocol_oneDrinkNotEnoughMoney_ExpectedMessageSend() {
        dmp.setMoney(0.1f);
        String result = dmp.order("tea", 1);
        assertEquals("M:0.3 missing", result);
    }

    @Test @Ignore
    public void DrinkMakerProtocol_oneDrinkEnoughMoney_ExpectedMoneyWithdraw() {
        dmp.order("chocolate", 0);
        float result = dmp.getMoney();
        assertEquals(1.15f, result, 0);
    }

    
    // Iteration 3 tests--------------------------------------------------------
    @Test
    public void DrinkMakerProtocol_newDrinkNoSugar_ExpectedStringFormat() {
        String result = dmp.order("orange", 0);
        assertEquals("O::", result);
    }

    @Test
    public void DrinkMakerProtocol_coldDrinkExtraHotAndSugarAttempt_ExpectedStringFormat() {
        String result = dmp.order("orange", 1, true);
        assertEquals("O::", result);
    }

    @Test @Ignore
    public void DrinkMakerProtocol_extraHotDrinkNoSugar_ExpectedStringFormat() {
        String result = dmp.order("chocolate", 0, true);
        assertEquals("Hh::", result);
    }

    @Test
    public void DrinkMakerProtocol_extraHotDrinkOneSugar_ExpectedStringFormat() {
        String result = dmp.order("coffee", 1, true);
        assertEquals("Ch:1:0", result);
    }

    
    // Iteration 4 tests--------------------------------------------------------
    @Test
    public void DrinkMakerProtocol_oneDrinkTwoValidOrders_ExpectedValidReportingTotalDrink() {
        String reference = "coffee";
        dmp.order(reference, 0);
        dmp.order(reference, 1, true);
        assertEquals(2, dmp.getReportingRepository().getTotalDrinks().get(reference).longValue());
    }

    @Test
    public void DrinkMakerProtocol_oneDrinkTwoValidOrders_ExpectedValidReportingTotalMoney() {
        dmp.order("coffee", 0);
        dmp.order("coffee", 1, true);        
        assertEquals(1.2f, dmp.getReportingRepository().getTotalMoney(), 0.005);
    }

    
    // Iteration 5 tests--------------------------------------------------------
    @Test
    public void DrinkMakerProtocol_orderEmptyDrink_ExpectedShortageMessage() { 
        dmp.setBeverageQuantityChecker(new MockingBeverageQuantityChecker());
        dmp.setEmailNotifier(new MockingEmailNotifier());
        String result = dmp.order("chocolate", 1, true);        
        assertEquals("M:there is a shortage on this drink, a notification has been sent to the company", result);
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }
}
