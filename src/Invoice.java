 /**
 * This is the class of Customers Object.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
import java.util.*;
public abstract class Invoice
{
     /**
     * Stores id of invoice
     */    
    private int id;
    
     /**
     * Stores object of the food in invoice
     */      
    private ArrayList<Food> foods;
    
     /**
     * Stores date of invoice
     */     
    private Calendar date;
    
     /**
     * Stores total pice of invoice
     */       
    protected int totalPrice = 0;
    
     /**
     * Stores total customer of invoice
     */    
    private Customer customer;
    
     /**
     * Stores status of invoice
     */
    private InvoiceStatus invoiceStatus;
    
    
     /**
     * Constructor for objects of class Invoice.
     * @param id is id for invoice
     * @param idFood is id for the food in invoice
     * @param date is the date when invoice is created
     * @param customer is the customer in the invoice
     * @param totalPrice is the total of the price in invoice
     */    
    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {
        this.id = id;
        this.foods = foods;
        this.date = Calendar.getInstance();
        this.customer = customer;
        this.invoiceStatus = InvoiceStatus.Ongoing;
        
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
    public ArrayList<Food> getFoods() {
        return foods;
    }

     /**
     * This method is used to manage id food of invoice.
     * @param idFood is id food for invoice
     */       
    public void setFoods( ArrayList<Food> foods) {
        this.foods = foods;
    }

     /**
     * This method is used to retrieves date of invoice.
     * @return int which returns id date of invoice.
     */     
    public Calendar getDate() {
        return date;
    }

     /**
     * This method is used to manage date of invoice.
     * @param date is date for invoice
     */    
    public void setDate(Calendar date) {
        this.date = date;
    }
    
    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year,month-1,dayOfMonth);
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
    public abstract void setTotalPrice();

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

    public abstract PaymentType getPaymentType();

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus status) {
        this.invoiceStatus = status;
    }
}
