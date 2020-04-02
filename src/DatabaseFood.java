import java.util.ArrayList;

/**
 * This is the class of Customers Object.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
public class DatabaseFood
{

    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Food getFoodById(int id){
        Food rFood = null;
        for (Food food: FOOD_DATABASE) {
            if(food.getId()==id){
                rFood = food;
            }
        }
        return rFood;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId){
        ArrayList<Food> rFoods = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if(food.getSeller().getId()==sellerId){
                rFoods.add(food);
            }
        }
        return rFoods;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory foodCategory){
        ArrayList<Food> rFoods = new ArrayList<>();
        for (Food food: FOOD_DATABASE) {
            if(food.getCategory()==foodCategory){
                rFoods.add(food);
            }
        }
        return rFoods;
    }

    public static boolean addFood(Food food){
        FOOD_DATABASE.add(food);
        lastId = lastId + 1;
        return true;
    }

    public static boolean removeFood(int id){
        boolean status = false;
        for (Food food: FOOD_DATABASE) {
            if(food.getId()==id){
                status=true;
            }
        }
        if(status){
            FOOD_DATABASE.remove(id);
        }
        return status;
    }

}
