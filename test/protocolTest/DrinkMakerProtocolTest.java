
package protocolTest;

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
    
    public DrinkMakerProtocolTest() {        
    }
    
    @BeforeClass
    public static void setUpClass() {
        DrinkMakerProtocol dmp = new DrinkMakerProtocol();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void DrinkMakerProtocol_oneDrinkOneSugar_ExpectedStringFormat(){
        String result = dmp.order("tea", 1);
        assertEquals("T:1:0", result);
    }
    
    @Test
    public void DrinkMakerProtocol_oneDrinkNoSugar_ExpectedStringFormat(){
        String result = dmp.order("chocolate", 0);
        assertEquals("H::", result);
    }
    
    @Test
    public void DrinkMakerProtocol_oneDrinkMoreThanTwoSugar_ExpectedStringFormat(){
        String result = dmp.order("coffee", 3);
        assertEquals("C:2:0", result);
    }
    
    @Test
    public void DrinkMakerProtocol_message_ExpectedStringFormat(){
        String content = "message content";
        String result = dmp.sendMessage(content);
        assertEquals("M:"+content, result);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
