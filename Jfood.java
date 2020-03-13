
/**
 * This is the main class of Application.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
public class Jfood
{
    /**
     * Constructor for objects of class Jfood
     */
    public Jfood()
    {
        // initialise instance variables
    }

    /**
    * This is the main method which makes use of addNum method.
    * @param args Unused.
    */
  
    public static void main(String[] args)
    {
        Location locationObj = new Location( "Padang", "Sumatera Barat", "Tempat lahir Penjual");
        Seller sellerObj = new Seller( 1, "Aqdam", "aqdamzh@gmail.com", "085934543920", locationObj);
        
        Food foodObj = new Food( 1, "Rendang", sellerObj, 9000, FoodCategory.Coffee);
        Customer customerObj = new Customer( 1, "Ukok", "Ukok@gmail.com", "Ukok123", "27-02-2020");
        CashInvoice invoiceObj1 = new CashInvoice( 1, foodObj, "06-03-2020", customerObj, InvoiceStatus.Finished);
        invoiceObj1.setTotalPrice();
        CashInvoice invoiceObj2 = new CashInvoice( 2, foodObj, "06-03-2020", customerObj, InvoiceStatus.Finished, 2000);
        invoiceObj2.setTotalPrice();
        
        invoiceObj1.printData();
        invoiceObj2.printData();
        
        
        
    }
}
