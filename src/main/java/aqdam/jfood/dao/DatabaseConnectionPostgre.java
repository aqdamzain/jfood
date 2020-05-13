package aqdam.jfood.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DatabaseConnectionPostgre is used to build the connection
 * to the database that use postgres RDBMS
 */
public class DatabaseConnectionPostgre {

    /**
     * get the connection of the database that
     * is used for executed query
     * @return Connection
     */
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
