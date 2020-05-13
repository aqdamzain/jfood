package aqdam.jfood.controller;

import aqdam.jfood.Promo;
import aqdam.jfood.dao.DatabasePromoPostgre;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * provide the controller for API request for promo
 */
@RequestMapping("/promo")
@RestController
public class PromoController {

    @RequestMapping("")
    public ArrayList<Promo> getAllPromo() {
        try {
            return DatabasePromoPostgre.getAllPromo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/{code}")
    public Promo getPromoByCode(@PathVariable String code) {
        try {
            return DatabasePromoPostgre.getPromoByCode(code);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code") String code,
                          @RequestParam(value = "discount") int discount,
                          @RequestParam(value = "minPrice") int minPrice,
                          @RequestParam(value = "active") boolean active) {
        Promo promo = null;
        promo = new Promo(DatabasePromoPostgre.getLastPromoId() + 1, code, discount, minPrice, active);
        try {
            DatabasePromoPostgre.insertPromo(promo);
            return promo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deletePromo(@PathVariable int id) {
        return DatabasePromoPostgre.removePromo(id);
    }
}
