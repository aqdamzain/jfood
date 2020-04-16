package aqdam.jfood.controller;

import aqdam.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/food")
@RestController
public class FoodController {

    @RequestMapping("")
    public ArrayList<Food> getAllFood(){
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        Food food = null;
        try {
            food = DatabaseFood.getFoodById(id);
        } catch (FoodNotFoundException e) {
            e.getMessage();
            return null;
        }
        return food;
    }

    @RequestMapping("/seller/{id}")
    public ArrayList<Food> getFoodBySeller(@PathVariable int id) {
        ArrayList<Food> food = new ArrayList<>();
        food = DatabaseFood.getFoodBySeller(id);
        return food;
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category){
        ArrayList<Food> food = new ArrayList<>();
        food = DatabaseFood.getFoodByCategory(category);
        return food;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                                     @RequestParam(value="price") int price,
                                     @RequestParam(value="category") FoodCategory category,
                                     @RequestParam(value="seller") int sellerId)
    {
        Food food = null;
        try {
            food = new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId), price, category);
            DatabaseFood.addFood(food);
        } catch (SellerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return food;
    }

}
