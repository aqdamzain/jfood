package aqdam.jfood.controller;

import aqdam.jfood.Customer;
import aqdam.jfood.dao.DatabaseCustomerPostgre;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * provide the controller for API request for customer
 */
@RequestMapping("/customer")
@RestController
public class CustomerController {

    /**
     * provide API for request customer based on id customer
     * @param id id of the customer
     * @return customer object
     */
    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = null;
        try {
            customer = DatabaseCustomerPostgre.getCustomerById(id);
            return customer;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * provide API request for add new customer to database
     * @param name name of customer
     * @param email email of customer that must unique
     * @param password password of customer for customer account
     * @return customer object
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "email") String email,
                                     @RequestParam(value = "password") String password) {
        try {
            Customer customer = new Customer(DatabaseCustomerPostgre.getLastCustomerId() + 1, name, email, password);
            DatabaseCustomerPostgre.insertCustomer(customer);
            return customer;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * provide api request for customer user credential
     * @param email email of the customer
     * @param password password of the customer
     * @return customer object
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String password) {
        try {
            Customer customer = DatabaseCustomerPostgre.getCustomer(email, password);
            return customer;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * provide API request for delete the customer from database
     * @param id id of the customer
     * @return true if succeed
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteCustomer(@PathVariable int id) {
        return DatabaseCustomerPostgre.removeCustomer(id);
    }


}