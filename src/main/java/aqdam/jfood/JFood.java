
/**
 * This is the main class of Application.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
package aqdam.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood
{
    public static void main(String[] args) {
        Location locationObj = new Location( "Padang", "Sumatera Barat", "Penjual Berjualan di tepi pantai");
        Location locationObj2 = new Location( "Sukabumi", "Jawa Barat", "Penjual Berjualan di gunung");
        Location locationObj3 = new Location( "Jakarta Pusat", "DKI Jakarta", "Penjual Berjualan di kita");
        DatabaseSeller.addSeller(new Seller( DatabaseSeller.getLastId()+1, "Aqdam", "aqdamzh@gmail.com", "085934543920", locationObj));
        DatabaseSeller.addSeller(new Seller( DatabaseSeller.getLastId()+1, "Harry", "hary@gmail.com", "085934543921", locationObj2));
        DatabaseSeller.addSeller(new Seller( DatabaseSeller.getLastId()+1, "Fahri", "fahri@gmail.com", "085934543922", locationObj3));

        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Starbuck Latte", DatabaseSeller.getSellerById(1), 40000, FoodCategory.Coffee));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Babi Panggang", DatabaseSeller.getSellerById(1), 60000, FoodCategory.Western));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Es Teh", DatabaseSeller.getSellerById(2), 10000, FoodCategory.Beverages));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseFood.addFood(new Food( DatabaseFood.getLastId()+1, "Onigiri", DatabaseSeller.getSellerById(3), 40000, FoodCategory.Japanese));
        } catch (SellerNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Aqdam","AqdamZh@gmail.com","Aqdam1234"));
        }catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseCustomer.addCustomer(new Customer( DatabaseCustomer.getLastId()+1,"Frenzel","Frenzel@gmail.com","Frenzel234"));
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

            SpringApplication.run(JFood.class, args);
    }
}
