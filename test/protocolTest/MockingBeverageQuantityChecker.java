/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolTest;

import coffee.machine.kata.BeverageQuantityChecker;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
public class MockingBeverageQuantityChecker implements BeverageQuantityChecker{
    
    private HashMap<String, Boolean> quantityList;    

    public MockingBeverageQuantityChecker(boolean stateCase) {
        this.quantityList = new HashMap();
        this.quantityList.put("tea", stateCase);
        this.quantityList.put("coffee", stateCase);
        this.quantityList.put("chocolate", stateCase);
        this.quantityList.put("orange", stateCase);
    }
        

    @Override
    public boolean isEmpty(String drink) {
        return this.quantityList.get(drink);
    }

    public HashMap<String, Boolean> getQuantityList() {
        return quantityList;
    }
    
    
}
