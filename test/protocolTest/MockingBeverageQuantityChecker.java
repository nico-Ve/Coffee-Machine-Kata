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

    public MockingBeverageQuantityChecker() {
        this.quantityList = new HashMap();
        this.quantityList.put("tea", false);
        this.quantityList.put("coffee", false);
        this.quantityList.put("chocolate", true);
        this.quantityList.put("orange", false);
    }
        

    @Override
    public boolean isEmpty(String drink) {
        return this.quantityList.get(drink);
    }
    
}
