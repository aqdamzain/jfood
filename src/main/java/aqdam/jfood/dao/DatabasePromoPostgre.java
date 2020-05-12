package aqdam.jfood.dao;

import aqdam.jfood.Promo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabasePromoPostgre {

    public static int getLastPromoId() {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        int lastId = 0;
        try {
            statement = connection.createStatement();
            String query = "select id from promo order by id desc limit 1";
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

    public static ArrayList<Promo> getAllPromo() throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        ArrayList<Promo> promos = new ArrayList<>();
        String query = "select * from promo";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            promos.add(new Promo(result.getInt("id"),
                    result.getString("code"),
                    result.getInt("discount"),
                    result.getInt("min_price"),
                    result.getBoolean("active")
            ));
        }
        return promos;
    }

    public static Promo getPromoById(int id) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Promo promo = null;
        String query = "select * from promo where " +
                "id='" + id + "' " +
                "limit 1";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            promo = new Promo(result.getInt("id"),
                    result.getString("code"),
                    result.getInt("discount"),
                    result.getInt("min_price"),
                    result.getBoolean("active"));
        }
        return promo;
    }

    public static Promo getPromoByCode(String code) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Promo promo = null;
        String query = "select * from promo where " +
                "code='" + code + "' " +
                "limit 1";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            promo = new Promo(result.getInt("id"),
                    result.getString("code"),
                    result.getInt("discount"),
                    result.getInt("min_price"),
                    result.getBoolean("active"));
        }
        if(promo == null){
            throw new SQLException();
        }
        return promo;
    }


    public static void insertPromo(Promo promo) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        String query = "insert into promo values(" +
                "'" + promo.getId() + "', " +
                "'" + promo.getCode() + "', " +
                "'" + promo.getDiscount() + "', " +
                "'" + promo.getMinPrice() + "', " +
                "'" + promo.getActive() + "' " +
                ")";
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    public static boolean activePromo(int id) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "update promo set active=true where " +
                    "id=" + id + "";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean deactivatePromo(int id) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "update promo set active=false where " +
                    "id=" + id + "";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean removePromo(int id) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "delete from promo where " +
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
