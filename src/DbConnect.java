import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnect {
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\DB\\dbevidence.db");
        return connection;
    }

    public void addEvidence(Evidence evidence){
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO evidence(counter_number, counter_reading, counter_type, reading_time) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, evidence.getSerialNo());
            preparedStatement.setString(2, evidence.getmValue());
            preparedStatement.setString(3, evidence.getDevType());
            preparedStatement.setString(4, evidence.getcTime());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
