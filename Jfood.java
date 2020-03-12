
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
        Promo promoObj1 = new Promo( 1, "PROMO1", 1000, 6000, true);
        Promo promoObj2 = new Promo( 2, "PROMO2", 2000, 10000, true);
        CashlessInvoice invoiceObj = new CashlessInvoice( 0, foodObj, "06-03-2020", customerObj, InvoiceStatus.Ongoing);
        invoiceObj.setTotalPrice();
        CashlessInvoice invoiceObj1 = new CashlessInvoice( 1, foodObj, "06-03-2020", customerObj, InvoiceStatus.Finished);
        invoiceObj1.setTotalPrice();
        CashlessInvoice invoiceObj2 = new CashlessInvoice( 2, foodObj, "06-03-2020", customerObj, InvoiceStatus.Finished, promoObj1);
        invoiceObj2.setTotalPrice();
        CashlessInvoice invoiceObj3 = new CashlessInvoice( 2, foodObj, "06-03-2020", customerObj, InvoiceStatus.Finished, promoObj2);
        invoiceObj3.setTotalPrice();
        
        invoiceObj.printData();
        invoiceObj1.printData();
        invoiceObj2.printData();
        invoiceObj3.printData();
        
        
        
    }
}
