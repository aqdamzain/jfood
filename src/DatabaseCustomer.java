import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * This is the class of Customers Object.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Customer> getCustomerDatabase(){
        return CUSTOMER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Customer getCustomerById(int id){
        Customer rCustomer = null;
        for (Customer customer: CUSTOMER_DATABASE) {
            if(customer.getId()==id){
                rCustomer = customer;
            }
        }
        return rCustomer;
    }

    public static boolean addCustomer(Customer customer){
        boolean status = false;
        if(CUSTOMER_DATABASE.isEmpty()){
            status = true;
        }else{
            for (Customer fCustomer: CUSTOMER_DATABASE) {
                if(!(fCustomer.getEmail().equals(customer.getEmail()))){
                    status = true;
                }
            }
        }
        if(status){
            CUSTOMER_DATABASE.add(customer);
            lastId = lastId + 1;
        }

        return status;
    }

    public static boolean removeCustomer(int id){
        boolean status = false;
        for (Customer customer: CUSTOMER_DATABASE) {
            if(customer.getId()==id){
                status=true;
            }
        }
        if(status){
            CUSTOMER_DATABASE.remove(id);
        }
        return status;
    }

}
