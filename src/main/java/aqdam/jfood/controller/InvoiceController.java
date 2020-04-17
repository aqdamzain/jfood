package aqdam.jfood.controller;

import aqdam.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id){
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
            return invoice;
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping("/customer/{customerId}")
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int id){
        return DatabaseInvoice.getInvoiceByCustomer(id);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                  @RequestParam(value="status") InvoiceStatus status)
    {
        if(DatabaseInvoice.changeInvoiceStatus(id, status)){
            try {
                return DatabaseInvoice.getInvoiceById(id);
            } catch (InvoiceNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id)
    {
        try {
            DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return true;
    }


    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                        @RequestParam(value="customerId") int customerId,
                        @RequestParam(value="deliveryFee") int deliveryFee)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for(int foodId : foodIdList){
            try {
                foods.add(DatabaseFood.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                e.getMessage();
            }
        }
        Invoice invoice = null;
        try {
            invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, foods,
                    DatabaseCustomer.getCustomerById(customerId), deliveryFee);
            invoice.setTotalPrice();
        } catch (CustomerNotFoundException e) {
            e.getMessage();
            return null;
        }
        try {
            DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="promoCode") String promoCode)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for(int foodId : foodIdList){
            try {
                foods.add(DatabaseFood.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                e.getMessage();
            }
        }
        Invoice invoice = null;
        try {
            invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods,
                    DatabaseCustomer.getCustomerById(customerId), DatabasePromo.getPromoByCode(promoCode));
            invoice.setTotalPrice();
        } catch (CustomerNotFoundException e) {
            e.getMessage();
            return null;
        }
        try {
            DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }



}
