
package coffee.machine.kata;

import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
public class DrinkMakerProtocol {
    
    private HashMap<String, String> optionsMap;
    private String messageCode;
    private char separator;

    public DrinkMakerProtocol() {
        this.optionsMap = new HashMap();
        this.optionsMap.put("tea", "T");
        this.optionsMap.put("chocolate", "H");
        this.optionsMap.put("coffee", "C");
        this.messageCode = "M";
        this.separator = ':';
    }
    
    public String order(String optionName, int sugarAmout){
        StringBuilder instruction = new StringBuilder();
        
        String optionCode = this.optionsMap.get(optionName);
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
}
