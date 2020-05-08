package aqdam.jfood.dao;

import aqdam.jfood.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCustomerPostgre {

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
        statement.close();
        connection.close();
        return customer;
    }

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
        statement.close();
        connection.close();
        return customer;
    }

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
