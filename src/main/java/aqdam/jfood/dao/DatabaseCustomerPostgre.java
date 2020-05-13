package aqdam.jfood.dao;

import aqdam.jfood.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * for query execution of table customer in the database
 */
public class DatabaseCustomerPostgre {

    /**
     * get the latest id of customer that inserted to database
     * @return id of the customer
     */
    public static int getLastCustomerId() {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        int lastId = 0;
        try {
            statement = connection.createStatement();
            String query = "select id from customer order by join_date desc limit 1";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                lastId = result.getInt("id");
            }
            statement.close();
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return lastId;
    }

    /**
     * Insert the new customer object to the
     * table customer of the database
     * @param customer is used to add new customer data to table customer
     * @throws SQLException throws exception if conditions are not met which
     * email must be different
     */
    public static void insertCustomer(Customer customer) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        String query = "insert into customer values(" +
                "'" + customer.getId() + "', " +
                "'" + customer.getName() + "', " +
                "'" + customer.getEmail() + "', " +
                "'" + customer.getPassword() + "', " +
                "'" + customer.getJoinDate() + "'" +
                ")";
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    /**
     *
     * @param email is email from user
     * @param password is password from user
     * @return new customer object
     * @throws SQLException throws exception if there is no customer based on
     * email and password in the table customer
     */
    public static Customer getCustomer(String email, String password) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Customer customer = null;
        String query = "select * from customer where " +
                "email='" + email + "' " +
                "and password='" + password + "' " +
                "limit 1";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            customer = new Customer(result.getShort("id"),
                    result.getString("name"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getTimestamp("join_date")
            );
        }
        if( customer == null){
            throw new SQLException();
        }
        statement.close();
        connection.close();
        return customer;
    }

    /**
     * get the customer object by the id from table customer in database
     * @param id is the identifier that customer has
     * @return customer object based on data from database in table customer
     * @throws SQLException throws exception if the query goes wrong
     */
    public static Customer getCustomerById(int id) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Customer customer = null;
        String query = "select * from customer where " +
                "id='" + id + "' " +
                "limit 1";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            customer = new Customer(result.getShort("id"),
                    result.getString("name"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getTimestamp("join_date")
            );
        }
        if( customer == null){
            throw new SQLException();
        }
        statement.close();
        connection.close();
        return customer;
    }

    /**
     * remove customer data from database based on id of the customer
     * @param id is the identifier that customer has
     * @return true if customer found in the database dan get removed
     */
    public static boolean removeCustomer(int id) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "delete from customer where " +
                    "id='" + id + "'";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
