import java.text.*;
import java.util.ArrayList;

public class CashlessInvoice extends Invoice
{
    
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;
    
    public CashlessInvoice( int id, ArrayList<Food> foods, Customer customer){
        super( id, foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo){
        super( id, foods, customer);
        this.promo = promo;
    }
    
    public PaymentType getPaymentType(){
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo(){
        return promo;
    }
    
    public void setPromo(Promo promo){
        this.promo = promo;
    }
    
    public void setTotalPrice(){
        int foodsPrice=0;
        for (Food food : super.getFoods()){
            foodsPrice = foodsPrice + food.getPrice();
        }
        if( !(promo==null) && promo.getActive() && foodsPrice > promo.getMinPrice()){
            super.totalPrice = foodsPrice - promo.getDiscount();
        }else{
            super.totalPrice = foodsPrice;
        }
    }
    
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String spromo = "";
        int foodsPrice=0;
        String foodsName = "";
        for (Food food : super.getFoods()){
            foodsPrice = foodsPrice + food.getPrice();
            foodsName = foodsName + food.getName() + ", ";
        }
        if(!(promo==null)){
        spromo = "\nPromo: " + promo.getCode();}
        String string = "\n=========== INVOICE ===========" +
                "\nID: " + super.getId() + "\nFood: " + foodsName + "\nDate: " + dateFormat.format(super.getDate().getTime()) + "\nCustomer: " + super.getCustomer().getName() + spromo
        + "\nTotal Price: " + super.totalPrice + "\nPayment Type: " +  PAYMENT_TYPE + "\nInvoice Status: " + super.getInvoiceStatus() + "\n";
        
        return string;
    }
}
