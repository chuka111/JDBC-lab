package ie.atu.jdbc.standard;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {
        // MySQL database connection details
        String url = "jdbc:mysql://localhost:3306/sampledatabase";
        String username = "root";
        String password = "password";

        // SQL statement
        String selectSQL = "SELECT c.id ,c.name, c.year, c.model " +
                "FROM car c "; //+
               // "JOIN emails e ON u.id = e.user_id";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String year = resultSet.getString("year");
                String model = resultSet.getString("model");

                System.out.println("name: " + name + ", year: " + year + ", model: " + model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
