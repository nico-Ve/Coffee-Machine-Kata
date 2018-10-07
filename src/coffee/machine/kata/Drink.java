
package coffee.machine.kata;

/**
 *
 * @author Nicolas
 */
public class Drink {
    private String code;
    private float price;
    private boolean hot;
    private boolean sugar;

    public Drink(String code, float price) {
        this.code = code;
        this.price = price;
        this.hot = true;
        this.sugar = true;
    }

    public Drink(String code, float price, boolean isHot, boolean hasSugar) {
        this.code = code;
        this.price = price;
        this.hot = isHot;
        this.sugar = hasSugar;
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

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean hasSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    
}
