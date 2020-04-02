import java.text.*;
public class CashlessInvoice extends Invoice
{
    
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;
    
    public CashlessInvoice( int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus){
        super( id, food, customer, invoiceStatus);
    }
    
    public CashlessInvoice( int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus, Promo promo){
        super( id, food, customer, invoiceStatus);
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
        if( !(promo==null) && promo.getActive() && super.getFood().getPrice() > promo.getMinPrice()){
            super.totalPrice = super.getFood().getPrice() - promo.getDiscount();
        }else{
            super.totalPrice = super.getFood().getPrice();
        }
    }
    
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String spromo = "";
        if( !(promo==null) && promo.getActive() && super.getFood().getPrice() > promo.getMinPrice()){
            spromo = "\nPromo: " + promo.getCode();
        }
        String string = "\nID: " + super.getId() + "\nFood: " + super.getFood().getName() + "\nDate: " + dateFormat.format(super.getDate().getTime()) + "\nCustomer: " + super.getCustomer().getName() + spromo
        + "\nTotal Price: " + super.totalPrice + "\nPayment Type: " +  PAYMENT_TYPE ;
        
        return string;
    }
}
