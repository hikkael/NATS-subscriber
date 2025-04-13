package Data.Services.Implementations;

import Data.Entities.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.time.OffsetDateTime;

import Data.Services.MessageRepository;

public class MessageRepositoryImp implements MessageRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/natsdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0000";

    public void save(Message message) {
        String sql = "INSERT INTO messages (content, timestamp) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, message.getContent());
            //stmt.setObject(2, OffsetDateTime.parse(message.getTimestamp())); 
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}