
public class CashInvoice extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;
    
    public CashInvoice( int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus){
        super( id, food, date, customer, invoiceStatus);
    }
    
    public CashInvoice( int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus, int deliveryFee){
        super( id, food, date, customer, invoiceStatus);
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
    public void printData(){
        System.out.println("==============INVOICE============");
        System.out.println("ID: " + super.getId());
        System.out.println("Food: " + super.getFood().getName());
        System.out.println("Date: " + super.getDate());
        System.out.println("Customer: " + super.getCustomer().getName());
        System.out.println("Delivery Fee: " + this.deliveryFee);
        System.out.println("Total Price: " + super.totalPrice);
        System.out.println("Payment Type: " +  PAYMENT_TYPE);
    }
}
