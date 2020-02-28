
public class Location
{
     /**
     * Stores province of location
     */     
    private String province;
    
     /**
     * Stores description of location
     */    
    private String description;
    
     /**
     * Stores city of location
     */      
    private String city;

     /**
     * Constructor for objects of class Location.
     * @param city is city in location
     * @param province is province in location
     * @param description is the description for location
     */        
    public Location( String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
    }

     /**
     * This method is used to retrieves province of location.
     * @return int which returns province of location.
     */     
    public String getProvince() {
        return province;
    }

     /**
     * This method is used to manage province of location.
     * @param province is province for location
     */     
    public void setProvince(String province) {
        this.province = province;
    }

     /**
     * This method is used to retrieves description of location.
     * @return int which returns description of location.
     */     
    public String getDescription() {
        return description;
    }

     /**
     * This method is used to manage description of location.
     * @param description is description for location
     */      
    public void setDescription(String description) {
        this.description = description;
    }

     /**
     * This method is used to retrieves city of location.
     * @return int which returns city of location.
     */    
    public String getCity() {
        return city;
    }

     /**
     * This method is used to manage city of location.
     * @param city is city for location
     */     
    public void setCity(String city) {
        this.city = city;
    }

     /**
     * This method is used to print data of location.
     */     
    public void printData(){
        System.out.println(province);
    }
}
