/**
 * This is the class of Customers Object.
 *
 * @author Aqdam Zain
 * @version 0.2
 * @since 28-02-2020
 */
package aqdam.jfood;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Customer {
    /**
     * Stores id of customer
     */
    private int id;
    /**
     * Stores name of customer
     */
    private String name;
    /**
     * Stores email of customer
     */
    private String email;
    /**
     * Stores password of customer
     */
    private String password;
    /**
     * Stores join date of customer
     */
    private Timestamp joinDate;

    /**
     * Constructor for objects of class Customer.
     * @param id is id for customer
     * @param name is the name of the customer
     * @param email is the email of the customer to login app
     * @param password is the password of the customer to login app
     * @param joinDate is the date when customer registered on app
     */
    public Customer(int id, String name, String email, String password, Timestamp joinDate) throws SQLException {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;

        setEmail(email);
        setPassword(password);

    }

    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth) throws SQLException {
        this.id = id;
        this.name = name;
        Calendar joinDate = new GregorianCalendar(year, month - 1, dayOfMonth);
        this.joinDate = DateAndCalendar.ConvertToDate(joinDate);
        setEmail(email);
        setPassword(password);
    }

    public Customer(int id, String name, String email, String password) throws SQLException {
        this.setEmail(email);
        this.setPassword(password);
        this.joinDate = DateAndCalendar.ConvertToDate(Calendar.getInstance());

        this.id = id;
        this.name = name;
    }

    /**
     * This method is used to retrieves id of customer.
     * @return int which returns id of customer.
     */
    public int getId() {
        return id;
    }

    /**
     * This method is used to manage id of customer.
     * @param id is id for customer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method is used to retrieves name of customer.
     * @return String which returns name of customer.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to manage name of customer.
     * @param name is the name of the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to retrieves email of customer.
     * @return String which returns email of customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method is used to manage email of customer.
     * @param email is the email of the customer to login app
     */
    public void setEmail(String email) throws SQLException {
        //String local = "([\\w\\&\\*_~]+\\.{0,1})+";
        //String domain = "[\\w][\\w\\-]*(\\.[\\w\\-]+)+";
        String regex = "^([\\w\\&\\*_~]+\\.{0,1})+@[\\w][\\w\\-]*(\\.[\\w\\-]+)+$";
        if (Pattern.matches(regex, email)) {
            this.email = email;
        } else {
            throw new SQLException();
        }
    }

    /**
     * This method is used to retrieves password of customer.
     * @return String which returns password of customer.
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to manage password of customer.
     * @param password is the password of the customer to login app 
     */
    public void setPassword(String password) throws SQLException {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        if (Pattern.matches(regex, password)) {
            this.password = password;
        } else {
            throw new SQLException();
        }
    }

    /**
     * This method is used to retrieves joinDate of customer.
     * @return String which returns joinDate of customer.
     */
    public Timestamp getJoinDate() {
        return joinDate;
    }

    /**
     * This method is used to manage joinDate of customer.
     * @param joinDate is the date when customer registered on app
     */
    public void setJoinDate(Calendar joinDate) {
        this.joinDate = DateAndCalendar.ConvertToDate(joinDate);
    }

    public void setJoinDate(int year, int month, int dayOfMonth) {
        Calendar joinDate = new GregorianCalendar(year, month - 1, dayOfMonth);
        this.joinDate = DateAndCalendar.ConvertToDate(joinDate);
    }

    /**
     * This method is used to print data of customer.
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String string = "\n=========== CUSTOMER ===========" +
                "\nId: " + this.id + "\nNama: " + this.name + "\nEmail: " + email + "\nPassword: " + password + "\nJoin Date: " +
                this.joinDate + "\n";
        return string;
    }
}
