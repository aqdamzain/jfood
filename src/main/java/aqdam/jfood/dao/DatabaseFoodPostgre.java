package aqdam.jfood.dao;

import aqdam.jfood.Food;
import aqdam.jfood.FoodCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseFoodPostgre {

    public static int getLastFoodId() {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        int lastId = 0;
        try {
            statement = connection.createStatement();
            String query = "select id from food order by id desc limit 1";
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

    public static ArrayList<Food> getAllFood() throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        ArrayList<Food> foods = new ArrayList<>();
        String query = "select * from food";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            foods.add(new Food(result.getInt("id"),
                    result.getString("name"),
                    DatabaseSellerPostgre.getSellerById(result.getInt("seller_id")),
                    result.getInt("price"),
                    FoodCategory.valueOf(result.getString("category"))
            ));
        }
        statement.close();
        connection.close();
        return foods;
    }

    public static Food getFoodById(int id) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        Food food = null;
        String query = "select * from food where " +
                "id='" + id + "' " +
                "limit 1";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            food = new Food(result.getInt("id"),
                    result.getString("name"),
                    DatabaseSellerPostgre.getSellerById(result.getInt("seller_id")),
                    result.getInt("price"),
                    FoodCategory.valueOf(result.getString("category"))
            );
        }
        if(food == null){
            throw new SQLException();
        }
        statement.close();
        connection.close();
        return food;
    }

    public static ArrayList<Food> getFoodBySeller(int seller_id) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        ArrayList<Food> foods = new ArrayList<>();
        String query = "select * from food where " +
                "seller_id='" + seller_id + "' ";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            foods.add(new Food(result.getInt("id"),
                    result.getString("name"),
                    DatabaseSellerPostgre.getSellerById(result.getInt("seller_id")),
                    result.getInt("price"),
                    FoodCategory.valueOf(result.getString("category"))
            ));
        }
        statement.close();
        connection.close();
        return foods;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        ArrayList<Food> foods = new ArrayList<>();
        String query = "select * from food where " +
                "category='" + category + "' ";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            foods.add(new Food(result.getInt("id"),
                    result.getString("name"),
                    DatabaseSellerPostgre.getSellerById(result.getInt("seller_id")),
                    result.getInt("price"),
                    FoodCategory.valueOf(result.getString("category"))
            ));
        }
        statement.close();
        connection.close();
        return foods;
    }

    public static void insertFood(Food food) throws SQLException {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = connection.createStatement();
        String query = "insert into food values(" +
                "'" + food.getId() + "', " +
                "'" + food.getName() + "', " +
                "'" + food.getSeller().getId() + "', " +
                "'" + food.getPrice() + "', " +
                "'" + food.getCategory() + "' " +
                ")";
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    public static boolean removeFood(int id) {
        Connection connection = DatabaseConnectionPostgre.connection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "delete from food where " +
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
