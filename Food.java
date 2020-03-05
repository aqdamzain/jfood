

public class Food
{
     /**
     * Stores id of food
     */
    private int id;

     /**
     * Stores name of food
     */    
    private String name;
    
     /**
     * Stores seller of the food
     */     
    private Seller seller;
    
     /**
     * Stores price of the food
     */     
    private int price;

     /**
     * Stores category of the food
     */  
    private FoodCategory category;

     /**
     * Constructor for objects of class Food.
     * @param id is id for food
     * @param name is the name of the food
     * @param seller is the seller of the food
     * @param price is the price of the food
     * @param category is the category of the food
     */    
    public Food( int id, String name, Seller seller, int price, FoodCategory category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }

     /**
     * This method is used to retrieves id of food.
     * @return int which returns id of food.
     */   
    public int getId() {
        return id;
    }

     /**
     * This method is used to manage id of food.
     * @param id is id for food
     */    
    public void setId(int id) {
        this.id = id;
    }

     /**
     * This method is used to retrieves name of food.
     * @return String which returns name of food.
     */    
    public String getName() {
        return name;
    }

     /**
     * This method is used to manage name of food.
     * @param name is the name of the food
     */      
    public void setName(String name) {
       this.name = name;
    }

     /**
     * This method is used to retrieves price of food.
     * @return String which returns price of food.
     */     
    public int getPrice() {
        return price;
    }

     /**
     * This method is used to manage price of food.
     * @param price is the price of the food
     */     
    public void setPrice(int price) {
        this.price = price;
    }

     /**
     * This method is used to retrieves category of food.
     * @return String which returns category of food.
     */     
    public FoodCategory getCategory() {
        return category;
    }

     /**
     * This method is used to manage category of food.
     * @param category is the category of the food
     */     
    public void setCategory(FoodCategory category) {
        this.category = category;
    }

     /**
     * This method is used to retrieves seller of food.
     * @return String which returns seller of food.
     */     
    public Seller getSeller(){
        return seller;
    }

     /**
     * This method is used to manage seller of food.
     * @param seller is the seller of the food
     */     
    public void setSeller( Seller seller){
        this.seller = seller;
    }

     /**
     * This method is used to print data of food.
     */      
    public void printData(){
        System.out.println("========FOOD========");
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Seller: " + this.seller.getName());
        System.out.println("City: " + this.seller.getLocation().getCity());
        System.out.println("Price: " + this.price);
         System.out.println("Category: " + this.category.toString());
    }
}
