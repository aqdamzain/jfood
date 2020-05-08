/**
 * This is the class of Customers Object.
 *
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
package aqdam.jfood;

public class Seller {
    /**
     * Stores id of seller
     */
    private int id;

    /**
     * Stores name of seller
     */
    private String name;

    /**
     * Stores email of seller
     */
    private String email;

    /**
     * Stores phone number of seller
     */
    private String phoneNumber;

    /**
     * Stores seller store location
     */
    private Location location;

    /**
     * Constructor for objects of class Seller.
     * @param id is id for seller
     * @param name is the name of the seller
     * @param email is the email of the seller
     * @param phoneNumber is the phone number of the seller
     * @param location is the location where seller is selling
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    /**
     * This method is used to retrieves id of seller.
     * @return int which returns id of seller.
     */
    public int getId() {
        return id;
    }

    /**
     * This method is used to manage id of seller.
     * @param id is id for seller
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method is used to retrieves name of seller.
     * @return String which returns name of seller.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to manage name of seller.
     * @param name is the name of the seller
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to retrieves email of seller.
     * @return String which returns email of seller.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method is used to manage email of seller.
     * @param email is the email of the seller
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method is used to retrieves phone number of seller.
     * @return String which returns phone number of seller.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method is used to manage phone number of seller.
     * @param phoneNumber is the phone number of the seller
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method is used to retrieves location of seller.
     * @return String which returns location of seller.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * This method is used to manage location of seller.
     * @param location is the location of the seller
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * This method is used to print data of seller.
     */
    @Override
    public String toString() {
        String string = "\n=========== SELLER ===========" +
                "\nId: " + this.id + "\nName: " + this.name + "\nPhone Number: " + this.phoneNumber + "\nLocation: " + this.location.getCity() + ", " + location.getProvince() + "\n";
        return string;
    }
}
