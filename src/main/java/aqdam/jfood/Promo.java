package aqdam.jfood;

public class Promo {
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    public Promo(int id, String code, int discount, int minPrice, boolean active) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        String string = "\n=========== PROMO ===========" +
                "\nID: " + this.id + "\nCode: " + this.code + "\nDiscount: " + this.discount + "\nMin Price: " + this.minPrice + "\nActive: " + this.active + "\n";
        return string;
    }
}
