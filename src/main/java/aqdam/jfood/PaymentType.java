 /**
 * This is the class of Customers Object.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
 package aqdam.jfood;

public enum PaymentType
{
    Cashless("Cashless"), Cash("Cash");
    
    private String type;
    
    PaymentType( String type){
        this.type = type;
    }
    
    public String toString(){
        return type;
    }
}
