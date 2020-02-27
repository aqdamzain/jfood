
/**
 * Write a description of class Jfood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jfood
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Jfood
     */
    public Jfood()
    {
        // initialise instance variables
    }

    public static void main(String[] args)
    {
        Location locationObj = new Location( "Bukittinggi", "Sumatera Barat", "Bukittinggi is the third largest city in West Sumatra, Indonesia, with a population of over 124,000 people and an area of 25.24 km².");
        Seller sellerObj = new Seller( 1, "Aqdam", "aqdamzh@gmail.com", "085934543920", locationObj);
        Food foodObj = new Food( 1, "Rendang", sellerObj, 9000, "Makanan");
        Customer customerObj = new Customer( 1, "Ukok", "Ukok@gmail.com", "Ukok123", "27-02-2020");
        Invoice invoiceObj = new Invoice( 1, 1, "27-02-2020", customerObj, 9000);
        locationObj.printData();
        sellerObj.printData();
        customerObj.printData();
    }
}
