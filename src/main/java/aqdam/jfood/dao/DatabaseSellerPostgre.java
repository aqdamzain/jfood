package aqdam.jfood.dao;

import aqdam.jfood.Location;
import aqdam.jfood.Seller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * for query execution of table seller in database
 */
public class DatabaseSellerPostgre {

    /**
     * get id of seller that latest inserted to database
     * @return id of seller
     */
    public static int getLastSellerId() {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        int lastId = 0;
        try {
            statement = connection.createStatement();
            String query = "select id from seller order by id desc limit 1";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                lastId = result.getInt("id");
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastId;
    }

    /**
     * get all seller from database
     * @return list all seller object
     * @throws SQLException throws exception if query goes wrong
     */
    public static ArrayList<Seller> getAllSeller() throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        ArrayList<Seller> sellers = new ArrayList<>();
        String query = "select * from seller";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            sellers.add(new Seller(result.getInt("id"),
                    result.getString("name"),
                    result.getString("email"),
                    result.getString("phone_number"),
                    new Location(result.getString("city"),
                            result.getString("province"),
                            result.getString("description"))
            ));
        }
        statement.close();
        connection.close();
        return sellers;
    }

    /**
     * get seller based on id that seller has
     * @param id id of seller
     * @return seller object
     * @throws SQLException throws exception if query goes wrong
     */
    public static Seller getSellerById(int id) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Seller seller = null;
        String query = "select * from seller where " +
                "id='" + id + "' " +
                "limit 1";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            seller = new Seller(result.getInt("id"),
                    result.getString("name"),
                    result.getString("email"),
                    result.getString("phone_number"),
                    new Location(result.getString("city"),
                            result.getString("province"),
                            result.getString("description"))
            );
        }
        statement.close();
        connection.close();
        return seller;
    }

    /**
     * insert seller to database
     * @param seller is seller object
     * @throws SQLException throws exception if query goes wrong
     */
    public static void insertSeller(Seller seller) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        String query = "insert into seller values(" +
                "'" + seller.getId() + "', " +
                "'" + seller.getName() + "', " +
                "'" + seller.getEmail() + "', " +
                "'" + seller.getPhoneNumber() + "', " +
                "'" + seller.getLocation().getCity() + "', " +
                "'" + seller.getLocation().getProvince() + "', " +
                "'" + seller.getLocation().getDescription() + "' " +
                ")";
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    /**
     * remove seller from database
     * @param id is id of the seller
     * @return true if seller found in database and get removed
     */
    public static boolean removeSeller(int id) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "delete from seller where " +
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
