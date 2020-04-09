
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

        //TEST add CUSTOMER EXCEPTION
        try {
            DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Ukok","Ukok@gmail.com","Ukokkoku123"));
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Koku","Ukok@gmail.com","Ukokkoku69"));
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Aqdam","AqdamZh@gmail.com","Aqdam1234"));
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Frenzel","Frenzel@gmail.com","Frenzel234"));
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("====== YANG MASUK DATABASE CUSTOMER ======");
        System.out.println(DatabaseCustomer.getCustomerDatabase());

        //TEST add PROMO EXCEPTION
        try {
            DatabasePromo.addPromo(new Promo( DatabasePromo.getLastId()+1, "DirumahAja", 10000, 50000, true));
        }catch (PromoCodeAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabasePromo.addPromo(new Promo( DatabasePromo.getLastId()+1, "DirumahAja", 15000, 60000, true));
        }catch (PromoCodeAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("====== YANG MASUK DATABASE PROMO ======");
        System.out.println(DatabasePromo.getPromoDatabase());

        //add food to DATABASE dan TEST SELLER id EXCEPTION
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Starbuck Latte", DatabaseSeller.getSellerById(1), 40000, FoodCategory.Coffee));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "KapalApi Susu", DatabaseSeller.getSellerById(2), 6000, FoodCategory.Coffee));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println("====== YANG MASUK DATABASE FOOD ======");
        System.out.println(DatabaseFood.getFoodDatabase());

        //TEST CUSTOMER id EXCEPTION
        try {
            System.out.println(DatabaseCustomer.getCustomerById(6));
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseCustomer.removeCustomer(5);
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        //TEST PROMO id EXCEPTION
        try {
            System.out.println(DatabasePromo.getPromoById(3));
        }catch (PromoNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabasePromo.removePromo(2);
        }catch (PromoNotFoundException e){
            System.out.println(e.getMessage());
        }

        //TEST PROMO id EXCEPTION
        try {
            System.out.println(DatabaseFood.getFoodById(3));
        }catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            DatabaseFood.removeFood(2);
        }catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Multithreading
        //insert food object to DATABASE
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Kelelawar Crispy", DatabaseSeller.getSellerById(1), 30000, FoodCategory.Snacks));
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "KapalApi Susu", DatabaseSeller.getSellerById(1), 6000, FoodCategory.Coffee));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Es Teh", DatabaseSeller.getSellerById(1), 3000, FoodCategory.Beverages));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Magelangan", DatabaseSeller.getSellerById(1), 10000, FoodCategory.Noodles));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }

        //add food to arr list
        ArrayList<Food> food1 = new ArrayList<>();
        try {
            food1.add(DatabaseFood.getFoodById(2));
        } catch (FoodNotFoundException e) {
            e.printStackTrace();
        }
        try {
            food1.add(DatabaseFood.getFoodById(1));
        } catch (FoodNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Food> food2 = new ArrayList<>();
        try {
            food2.add(DatabaseFood.getFoodById(3));
        } catch (FoodNotFoundException e) {
            e.printStackTrace();
        }
        try {
            food2.add(DatabaseFood.getFoodById(2));
        } catch (FoodNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Food> food3 = new ArrayList<>();
        try {
            food3.add(DatabaseFood.getFoodById(4));
        } catch (FoodNotFoundException e) {
            e.printStackTrace();
        }
        try {
            food3.add(DatabaseFood.getFoodById(5));
        } catch (FoodNotFoundException e) {
            e.printStackTrace();
        }

        //insert invoice object to DATABASE
        try {
            DatabaseInvoice.addInvoice(new CashlessInvoice( DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        } catch (PromoNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new CashInvoice( DatabaseInvoice.getLastId()+1, food2, DatabaseCustomer.getCustomerById(2), 1));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new CashInvoice( DatabaseInvoice.getLastId()+1, food3, DatabaseCustomer.getCustomerById(3), 1));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n//Calculate invoice using thread");
        for( Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){
            new Thread(new PriceCalculator(invoice)).start();
        }
    }
}
