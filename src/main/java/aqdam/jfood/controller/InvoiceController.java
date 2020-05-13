package aqdam.jfood.controller;

import aqdam.jfood.*;
import aqdam.jfood.dao.DatabaseCustomerPostgre;
import aqdam.jfood.dao.DatabaseFoodPostgre;
import aqdam.jfood.dao.DatabaseInvoicePostgre;
import aqdam.jfood.dao.DatabasePromoPostgre;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * provide the controller for API request for invoice
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        try {
            return DatabaseInvoicePostgre.getAllInvoice();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        try {
            return DatabaseInvoicePostgre.getInvoiceById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/customer/{customerId}")
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) {
        try {
            return DatabaseInvoicePostgre.getInvoiceByCustomer(customerId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) {
        if (DatabaseInvoicePostgre.changeInvoiceStatus(id, status)) {
            try {
                return DatabaseInvoicePostgre.getInvoiceById(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        return DatabaseInvoicePostgre.removeInvoice(id);
    }

    @RequestMapping(value = "/createCashInvoice",
            method = RequestMethod.POST, params = {"foodIdList", "customerId"})
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value = "customerId") int customerId) {
        try {
            ArrayList<Food> foods = new ArrayList<>();
            for (int foodId : foodIdList) {
                foods.add(DatabaseFoodPostgre.getFoodById(foodId));
            }
            Invoice invoice = new CashInvoice(DatabaseInvoicePostgre.getLastInvoiceId() + 1, foods,
                    DatabaseCustomerPostgre.getCustomerById(customerId));
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertInvoice(invoice);
            return invoice;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/createCashInvoice",
            method = RequestMethod.POST, params = {"foodIdList", "customerId", "deliveryFee"})
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value = "customerId") int customerId,
                                  @RequestParam(value = "deliveryFee") int deliveryFee) {

        try {
            ArrayList<Food> foods = new ArrayList<>();
            for (int foodId : foodIdList) {
                foods.add(DatabaseFoodPostgre.getFoodById(foodId));
            }
            Invoice invoice = new CashInvoice(DatabaseInvoicePostgre.getLastInvoiceId() + 1, foods,
                    DatabaseCustomerPostgre.getCustomerById(customerId), deliveryFee);
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertInvoice(invoice);
            return invoice;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST, params = {"foodIdList", "customerId", "promoCode"})
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "promoCode") String promoCode) {
        try {
            ArrayList<Food> foods = new ArrayList<>();
            for (int foodId : foodIdList) {
                foods.add(DatabaseFoodPostgre.getFoodById(foodId));
            }
            Invoice invoice = new CashlessInvoice(DatabaseInvoicePostgre.getLastInvoiceId() + 1, foods,
                    DatabaseCustomerPostgre.getCustomerById(customerId), DatabasePromoPostgre.getPromoByCode(promoCode));
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertInvoice(invoice);
            return invoice;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST, params = {"foodIdList", "customerId"})
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value = "customerId") int customerId) {
        try {
            ArrayList<Food> foods = new ArrayList<>();
            for (int foodId : foodIdList) {
                foods.add(DatabaseFoodPostgre.getFoodById(foodId));
            }
            Invoice invoice = new CashlessInvoice(DatabaseInvoicePostgre.getLastInvoiceId() + 1, foods,
                    DatabaseCustomerPostgre.getCustomerById(customerId));
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertInvoice(invoice);
            return invoice;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
