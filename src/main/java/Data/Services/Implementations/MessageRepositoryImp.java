package Data.Services.Implementations;

import Data.Services.MessageRepository;
import Data.Entities.*;
import java.sql.*;
import java.time.OffsetDateTime;

public class MessageRepositoryImp implements MessageRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/nutsdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0000";

    public void save(Message message) {
        String sql = "INSERT INTO messages (content, timestamp) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, message.getContent());
            stmt.setObject(2, OffsetDateTime.parse(message.getTimestamp()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}