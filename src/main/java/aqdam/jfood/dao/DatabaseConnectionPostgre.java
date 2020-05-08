package aqdam.jfood.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionPostgre {

    public static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/jfood",
                            "postgres", "");
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return c;
    }
}
