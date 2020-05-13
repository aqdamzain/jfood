package aqdam.jfood.controller;

import aqdam.jfood.Food;
import aqdam.jfood.FoodCategory;
import aqdam.jfood.dao.DatabaseFoodPostgre;
import aqdam.jfood.dao.DatabaseSellerPostgre;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * provide the controller for API request for food
 */
@RequestMapping("/food")
@RestController
public class FoodController {

    /**
     * provide API for request All food
     * @return list of food
     */
    @RequestMapping("")
    public ArrayList<Food> getAllFood() {
        try {
            return DatabaseFoodPostgre.getAllFood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * provide API for get request food based on food id
     * @param id id of food
     * @return food
     */
    @RequestMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        try {
            return DatabaseFoodPostgre.getFoodById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * create API get request for list of food based on food id
     * @param id id of food
     * @return list of food
     */
    @RequestMapping("/seller/{id}")
    public ArrayList<Food> getFoodBySeller(@PathVariable int id) {
        try {
            return DatabaseFoodPostgre.getFoodBySeller(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * create API get request for list of food based on category of the food
     * @param category category or type of food
     * @return list of food
     */
    @RequestMapping("/category/{category}")
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        try {
            return DatabaseFoodPostgre.getFoodByCategory(category);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * create API post request for add new food to database
     * @param name name of food
     * @param price price for food
     * @param category category or type of food
     * @param sellerId seller that sell the food
     * @return food object
     */
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
