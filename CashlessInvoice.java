
public class CashlessInvoice extends Invoice
{
    
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;
    
    public CashlessInvoice( int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus){
        super( id, food, date, customer, invoiceStatus);
    }
    
    public CashlessInvoice( int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus, Promo promo){
        super( id, food, date, customer, invoiceStatus);
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
    public void printData(){
        System.out.println("==============INVOICE============");
        System.out.println("ID: " + super.getId());
        System.out.println("Food: " + super.getFood().getName());
        System.out.println("Date: " + super.getDate());
        System.out.println("Customer: " + super.getCustomer().getName());
        if( !(promo==null) && promo.getActive() && super.getFood().getPrice() > promo.getMinPrice()){
            System.out.println("Promo: " + promo.getCode());
        }
        System.out.println("Total Price: " + super.totalPrice);
        System.out.println("Payment Type: " +  PAYMENT_TYPE);
    }
}
