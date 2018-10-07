
package coffee.machine.kata;

import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
public class DrinkMakerProtocol {
    
    private HashMap<String, Drink> options;
    private String messageCode;
    private String extraHotCode;
    private String separator;    
    private float money;
    
    private ReportingRepository reportingRepository;

    public DrinkMakerProtocol() {
        this.options = new HashMap();   
        this.reportingRepository = new ReportingRepository();
    }
    
    
    public String order(String optionName, int sugarAmout){
        return order(optionName, sugarAmout, false);
    }
    
    public String order(String optionName, int sugarAmout, boolean isExtraHot){
        Drink option = this.options.get(optionName);
        
        if(option == null){
            return sendMessage("no drink available");
        }        
        if (this.money < option.getPrice()){
            String messageBody = (option.getPrice()-this.money)+ " missing";
            return sendMessage(messageBody);
        }
        
        setMoney(this.money-option.getPrice());
        StringBuilder instruction = new StringBuilder();                
        instruction.append(option.getCode());
        
        if(isExtraHot && option.isHot()){
            instruction.append(this.extraHotCode);
        }
        
        instruction.append(this.separator);
        
        if(!option.hasSugar() || sugarAmout <= 0){
            instruction.append(this.separator);
        } else if (sugarAmout == 1){
            instruction.append("1").append(this.separator).append("0");
        } else {
            instruction.append("2").append(this.separator).append("0");
        }
        
        this.reportingRepository.addDrink(optionName);
        this.reportingRepository.addMoney(option.getPrice());
        String result = instruction.toString();
        return result;        
    }
    
    
    public String sendMessage(String messageBody){
        String result = this.messageCode + this.separator + messageBody;
        return result;
    }             

    public HashMap<String, Drink> getOptions() {
        return options;
    }

    public void setOptions(HashMap<String, Drink> options) {
        this.options = options;
    }     

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getExtraHotCode() {
        return extraHotCode;
    }

    public void setExtraHotCode(String extraHotCode) {
        this.extraHotCode = extraHotCode;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }        
    
    public void setMoney(float balance) {
        this.money = balance;
    }   

    public float getMoney() {
        return money;
    }        

    public ReportingRepository getReportingRepository() {
        return reportingRepository;
    }        
    
    public void setReportingRepository() {
        this.reportingRepository.setTotalDrinks(this.options);
    }
}
