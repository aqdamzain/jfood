
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
        Calendar calendar = Calendar.getInstance();  
        Customer customerObj = new Customer( 1, "Ukok", "Uko..k@gmaicom", "ukokkoku", calendar);
        Customer customerObj2 = new Customer( 1, "Ukok", "Ukok@gmai.com", "Ukokkoku123", 2019, 2, 19);
        Customer customerObj3 = new Customer( 1, "Ukok", "Uko..k@gmaicom", "Ukokkoku123");
        
        System.out.println(customerObj);
        System.out.println(customerObj2);
        System.out.println(customerObj3);
        
    }
}