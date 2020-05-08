package aqdam.jfood.controller;

import aqdam.jfood.Location;
import aqdam.jfood.Seller;
import aqdam.jfood.dao.DatabaseSellerPostgre;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RequestMapping("/seller")
@RestController
public class SellerController {

    @RequestMapping("")
    public ArrayList<Seller> getAllSeller() {
        try {
            return DatabaseSellerPostgre.getAllSeller();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/{id}")
    public Seller getSellerById(@PathVariable int id) {
        try {
            return DatabaseSellerPostgre.getSellerById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name,
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "province") String province,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "city") String city) {
        Seller seller = new Seller(DatabaseSellerPostgre.getLastSellerId() + 1,
                name, email, phoneNumber, new Location(city, province, description));
        try {
            DatabaseSellerPostgre.insertSeller(seller);
            return seller;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteSeller(@PathVariable int id) {
        return DatabaseSellerPostgre.removeSeller(id);
    }

}
