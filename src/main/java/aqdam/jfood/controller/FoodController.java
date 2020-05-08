package aqdam.jfood.controller;

import aqdam.jfood.Food;
import aqdam.jfood.FoodCategory;
import aqdam.jfood.dao.DatabaseFoodPostgre;
import aqdam.jfood.dao.DatabaseSellerPostgre;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RequestMapping("/food")
@RestController
public class FoodController {

    @RequestMapping("")
    public ArrayList<Food> getAllFood() {
        try {
            return DatabaseFoodPostgre.getAllFood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        try {
            return DatabaseFoodPostgre.getFoodById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/seller/{id}")
    public ArrayList<Food> getFoodBySeller(@PathVariable int id) {
        try {
            return DatabaseFoodPostgre.getFoodBySeller(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        try {
            return DatabaseFoodPostgre.getFoodByCategory(category);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name") String name,
                        @RequestParam(value = "price") int price,
                        @RequestParam(value = "category") FoodCategory category,
                        @RequestParam(value = "seller") int sellerId) {
        try {
            Food food = new Food(DatabaseFoodPostgre.getLastFoodId() + 1, name,
                    DatabaseSellerPostgre.getSellerById(sellerId), price, category);
            DatabaseFoodPostgre.insertFood(food);
            return food;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteFood(@PathVariable int id) {
        return DatabaseFoodPostgre.removeFood(id);
    }

}
