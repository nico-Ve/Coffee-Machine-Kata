
package protocolTest;

import coffee.machine.kata.EmailNotifier;

/**
 *
 * @author Nicolas
 */
public class MockingEmailNotifier implements EmailNotifier{

    @Override
    public void notifyMissingDrink(String drink) {
        System.out.println(drink + " is missing, a refill is necessary");
    }
    
}
