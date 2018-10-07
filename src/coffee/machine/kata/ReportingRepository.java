
package coffee.machine.kata;

import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
public class ReportingRepository {
    
    private HashMap<String, Long> totalDrinks;
    private float totalMoney;

    public ReportingRepository() {
        this.totalDrinks = new HashMap();
        this.totalMoney = 0;
    }

    public HashMap<String, Long> getTotalDrinks() {
        return totalDrinks;
    }   

    public float getTotalMoney() {
        return totalMoney;
    } 

    public void setTotalDrinks(HashMap<String, Drink> options) {
        for(String key : options.keySet()){
            this.totalDrinks.put(key, 0L);
        }
    }        

    public void addDrink(String reference) {
        Long value = this.totalDrinks.get(reference);
        value++;     
        this.totalDrinks.put(reference, value);
    }

    public void addMoney(float money) {
        this.totalMoney += money;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(String key : totalDrinks.keySet()){
            output.append(key).append(" : ").append(totalDrinks.get(key)).append("\n");
        }
        output.append("total money : ").append(totalMoney);
        return output.toString();
    }        
}
