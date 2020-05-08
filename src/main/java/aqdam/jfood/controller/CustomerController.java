package aqdam.jfood.controller;

import aqdam.jfood.Customer;
import aqdam.jfood.dao.DatabaseCustomerPostgre;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/customer")
@RestController
public class CustomerController {

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "email") String email,
                                     @RequestParam(value = "password") String password) {
        Customer customer = new Customer(DatabaseCustomerPostgre.getLastCustomerId() + 1, name, email, password);
        try {
            DatabaseCustomerPostgre.insertCustomer(customer);
            return customer;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteCustomer(@PathVariable int id) {
        return DatabaseCustomerPostgre.removeCustomer(id);
    }


}