 /**
 * This is the class of Customers Object.
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
 package aqdam.jfood;

public enum FoodCategory
{
    Beverages("Beverages"), Coffee("Coffee"), Western("Western"), Snacks("Snacks"),
    Rice("Rice"), Noodles("Noodles"), Bakery("Bakery"), Japanese("Japanese");
    
    private String category;
    
    FoodCategory( String category){
        this.category = category;
    }
    
    public String toString(){
        return category;
    }
}
