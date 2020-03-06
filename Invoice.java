 /**
 * This is the class of Customers Object.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
public class Invoice
{
     /**
     * Stores id of invoice
     */    
    private int id;
    
     /**
     * Stores id of the food in invoice
     */      
    private int idFood;
    
     /**
     * Stores date of invoice
     */     
    private String date;
    
     /**
     * Stores total pice of invoice
     */       
    private int totalPrice;
    
     /**
     * Stores total customer of invoice
     */    
    private Customer customer;
    
    /**
     * Stores payment type of invoice
     */ 
    private PaymentType paymentType;
    
     /**
     * Stores status of invoice
     */
    private InvoiceStatus status;
    
     /**
     * Constructor for objects of class Invoice.
     * @param id is id for invoice
     * @param idFood is id for the food in invoice
     * @param date is the date when invoice is created
     * @param customer is the customer in the invoice
     * @param totalPrice is the total of the price in invoice
     */    
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice, InvoiceStatus status)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.status = status;
        
    }

     /**
     * This method is used to retrieves id of invoice.
     * @return int which returns id of invoice.
     */    
    public int getId() {
        return id;
    }

     /**
     * This method is used to manage id of invoice.
     * @param id is id for invoice
     */     
    public void setId(int id) {
        this.id = id;
    }

     /**
     * This method is used to retrieves id food of invoice.
     * @return int which returns id food of invoice.
     */     
    public int getIdFood() {
        return idFood;
    }

     /**
     * This method is used to manage id food of invoice.
     * @param idFood is id food for invoice
     */       
    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

     /**
     * This method is used to retrieves date of invoice.
     * @return int which returns id date of invoice.
     */     
    public String getDate() {
        return date;
    }

     /**
     * This method is used to manage date of invoice.
     * @param date is date for invoice
     */    
    public void setDate(String date) {
        this.date = date;
    }

     /**
     * This method is used to retrieves total price of invoice.
     * @return int which returns total price of invoice.
     */     
    public int getTotalPrice() {
        return totalPrice;
    }

     /**
     * This method is used to manage total price of invoice.
     * @param totalPrice is total price for invoice
     */    
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

     /**
     * This method is used to retrieves total customer of invoice.
     * @return int which returns customer of invoice.
     */     
    public Customer getCustomer(){
        return customer;
    }

     /**
     * This method is used to manage customer of invoice.
     * @param customer is customer for invoice
     */    
    public void setCustomer( Customer customer){
        this.customer = customer;
    }

        public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }
    
     /**
     * This method is used to print data of invoice.
     */      
    public void printData(){
        System.out.println("========INVOICE========\n"
         + "ID: " + this.id + "\n"
         + "Food ID: " + this.idFood + "\n"
         + "Date: " + this.date + "\n"
         + "Customer: " + this.customer.getName() + "\n"
         + "Total Price: " + this.totalPrice + "\n"
         + "Status: " + this.status);
    }
    
}
