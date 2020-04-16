package aqdam.jfood;

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

    public static Customer getCustomerById(int id) throws CustomerNotFoundException {
        Customer rCustomer = null;
        boolean eVar = true;
        for (Customer customer: CUSTOMER_DATABASE) {
            if(customer.getId()==id){
                rCustomer = customer;
                eVar = false;
            }
        }
        if(eVar){
            throw new CustomerNotFoundException(id);
        }
        return rCustomer;
    }

    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException {
        boolean rVar = true;
        if(!(CUSTOMER_DATABASE.isEmpty())){
            for (Customer fCustomer: CUSTOMER_DATABASE) {
                if(fCustomer.getEmail().equals(customer.getEmail())){
                    rVar = false; }
            }
        }
        if(rVar){
            CUSTOMER_DATABASE.add(customer);
            lastId = customer.getId();
        }else {
            throw new EmailAlreadyExistsException(customer);
        }
        return rVar;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        boolean rVar = false;
        int customerIndex = -1;
        for (Customer customer: CUSTOMER_DATABASE) {
            if(customer.getId()==id){
                customerIndex = CUSTOMER_DATABASE.indexOf(customer);
                rVar=true;
            }
        }
        if(rVar){
            CUSTOMER_DATABASE.remove(customerIndex);
        }else{
            throw new CustomerNotFoundException(id);
        }
        return rVar;
    }

    public static Customer getCustomerLogin(String email, String password){
        boolean rVar = false;
        int customerIndex = -1;
        for (Customer customer: CUSTOMER_DATABASE) {
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                customerIndex = CUSTOMER_DATABASE.indexOf(customer);
                rVar=true;
            }
        }
        if(rVar){
            return  CUSTOMER_DATABASE.get(customerIndex);
        }
        return null;
    }

}
