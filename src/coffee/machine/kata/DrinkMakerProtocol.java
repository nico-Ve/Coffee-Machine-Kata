
package coffee.machine.kata;

import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
public class DrinkMakerProtocol {
    
    private HashMap<String, Drink> optionsMap;
    private String messageCode;
    private char separator;
    private float money;

    public DrinkMakerProtocol() {
        this.optionsMap = new HashMap();
        this.optionsMap.put("tea", new Drink("T", 0.4f));
        this.optionsMap.put("chocolate", new Drink("H", 0.5f));
        this.optionsMap.put("coffee", new Drink("C", 0.6f));
        this.messageCode = "M";
        this.separator = ':';
    }
    
    public String order(String optionName, int sugarAmout){
        Drink option = this.optionsMap.get(optionName);
        String optionCode = option.getCode();
             
        if (this.money < option.getPrice()){
            String messageBody = (option.getPrice()-this.money)+ " missing";
            return sendMessage(messageBody);
        }
        
        setMoney(this.money-option.getPrice());
        StringBuilder instruction = new StringBuilder();                
        instruction.append(optionCode).append(separator);
        
        if(sugarAmout <= 0){
            instruction.append(separator);
        } else if (sugarAmout == 1){
            instruction.append("1").append(separator).append("0");
        } else {
            instruction.append("2").append(separator).append("0");
        }
        
        String result = instruction.toString();
        return result;        
    }
    
    public String sendMessage(String messageBody){
        String result = this.messageCode + separator + messageBody;
        return result;
    }             

    public void setMoney(float balance) {
        this.money = balance;
    }   

    public float getMoney() {
        return money;
    }        
    
}
