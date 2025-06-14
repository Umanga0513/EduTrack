package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws Exception {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/edu", "root", "");
                System.out.println("Database Connected!");
            } catch (SQLException e) {
                System.out.println("Database Connection Failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }

}