package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class constant {

    private static final String DB_URL = "jdbc:mysql://localhost:8111/uts-pbo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }
}
