
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

        
        foodObj.printData();
        
        
    }
}
