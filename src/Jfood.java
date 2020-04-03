
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
        Location locationObj = new Location( "Padang", "Sumatera Barat", "Penjual Berjualan di tepi pantai");

        DatabaseSeller.addSeller(new Seller( DatabaseSeller.getLastId()+1, "Aqdam", "aqdamzh@gmail.com", "085934543920", locationObj));

        DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Ukok","Ukok@gmail.com","Ukokkoku123"));
        DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Ukok","Ukok@gmail.com","Ukokkoku69"));
        DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Frenzel","Frenzel@gmail.com","Frenzel23"));
        DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Starbuck Latte", DatabaseSeller.getSellerById(1), 40000, FoodCategory.Coffee));
        DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "KapalApi Susu", DatabaseSeller.getSellerById(1), 6000, FoodCategory.Coffee));
        DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Kelelawar Crispy", DatabaseSeller.getSellerById(1), 30000, FoodCategory.Snacks));
        System.out.println(DatabaseCustomer.getCustomerDatabase());
        System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Coffee));

        DatabasePromo.addPromo(new Promo( DatabaseFood.getLastId()+1, "DirumahAja", 10000, 50000, false));
        DatabasePromo.addPromo(new Promo( DatabaseFood.getLastId()+1, "DirumahAja", 15000, 60000, true));
        System.out.println(DatabasePromo.getPromoDatabase());

        ArrayList<Food> food1 = new ArrayList<>(); food1.add(DatabaseFood.getFoodById(1)); food1.add(DatabaseFood.getFoodById(3));
        ArrayList<Food> food2 = new ArrayList<>(); food2.add(DatabaseFood.getFoodById(2)); food2.add(DatabaseFood.getFoodById(3));

        DatabaseInvoice.addInvoice(new CashInvoice( DatabaseFood.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), 1));
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();
        System.out.println(DatabaseInvoice.getInvoiceDatabase());

        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setInvoiceStatus(InvoiceStatus.Finished);

        DatabaseInvoice.addInvoice(new CashlessInvoice( DatabaseFood.getLastId()+1, food1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(1)));

        








        
    }
}
