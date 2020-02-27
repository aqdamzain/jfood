

public class Food
{
    private int id;
    private String name;
    private Seller seller;
    private int price;
    private String category;

    public Food( int id, String name, Seller seller, int price, String category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public Seller getSeller(){
        return seller;
    }
    
    public void setSeller( Seller seller){
        this.seller = seller;
    }
    
    public void printData(){
    }
}
