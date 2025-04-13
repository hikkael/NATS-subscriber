package Data.Services.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCheck {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/natsdb";
        String user = "postgres";
        String password = "0000";


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connection successful!");
        } catch (SQLException e) {
            System.err.println("❌ DB connection failed: " + e.getMessage());
        }
    }
}