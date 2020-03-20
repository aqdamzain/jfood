import java.text.*;
public class CashInvoice extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;
    
    public CashInvoice( int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus){
        super( id, food, customer, invoiceStatus);
    }
    
    public CashInvoice( int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus, int deliveryFee){
        super( id, food, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }
    
    @Override
    public PaymentType getPaymentType(){
        return PAYMENT_TYPE;
    }
    
    public int getDeliveryFee(){
        return deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee){
        this.deliveryFee = deliveryFee;
    }
    
    @Override
    public void setTotalPrice(){
        if(!(deliveryFee==0)){
            super.totalPrice = super.getFood().getPrice() + deliveryFee;
        }else{
            super.totalPrice = super.getFood().getPrice();
        }
        
    }
    
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String string = "ID: " + super.getId() + "\nFood: " + super.getFood().getName() + "\nDate: " + dateFormat.format(super.getDate().getTime()) + "\nCustomer: " + super.getCustomer().getName()
        + "\nDelivery Fee: " + this.deliveryFee + "\nTotal Price: " + super.totalPrice + "\nPayment Type: " +  PAYMENT_TYPE ;
        
        return string;
    }
}
