package infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.entity.User;
import domain.service.UserService;
import infrastructure.config.DatabaseConfig;

public class UserRepository implements UserService {
    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS )) {
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
            
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getLong(1));
                    }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }

    @Override
    public User findUserById(Long id) {
        String sql = "SELECT id, name, email FROM users WHERE id = ?";
        User user = null;

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, id);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if(resultSet.next()) {
                            user = new User();
                            user.setId(resultSet.getLong("id"));
                            user.setName(resultSet.getString("name"));
                            user.setEmail(resultSet.getString("email"));
                        }
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User deleteUserById(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            
            if(rowsDeleted > 0) {
                System.out.println("Datos borrados correctamente.");
            } else {
                System.out.println("No se encontro ningun dato con ese ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
}   
