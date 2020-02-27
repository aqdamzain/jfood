
public class Location
{
    private String province;
    private String description;
    private String city;

    public Location( String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void printData(){
        System.out.println(province);
    }
}
