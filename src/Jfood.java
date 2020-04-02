
/**
 * This is the main class of Application.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
import java.util.*;
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
        Food foodObj = new Food( 1, "Starbuck", sellerObj, 9000, FoodCategory.Coffee);
        Customer customerObj = new Customer( 3,"Ukok",".Ukok@gmai.com","Ukokkoku123");
        Promo promoObj1 = new Promo( 1, "PROMO1", 1000, 6000, true);
        
        CashInvoice invoiceObj1 = new CashInvoice( 1, foodObj, customerObj, InvoiceStatus.Finished);
        CashlessInvoice invoiceObj2 = new CashlessInvoice( 2, foodObj, customerObj, InvoiceStatus.Finished, promoObj1);
        
        System.out.println(invoiceObj1);
        System.out.println(invoiceObj2);
        
    }
}
