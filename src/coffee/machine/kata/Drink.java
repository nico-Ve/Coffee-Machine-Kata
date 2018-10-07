
package coffee.machine.kata;

/**
 *
 * @author Nicolas
 */
public class Drink {
    private String code;
    private float price;

    public Drink(String code, float price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    
}
