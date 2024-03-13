package ie.atu.jdbc.pool;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {
        String selectSQL = "SELECT c.id ,c.name, c.year, c.model " +
                "FROM car c "; //+
               // "JOIN emails e ON u.id = e.user_id";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String year = resultSet.getString("year");
                String model = resultSet.getString("model");

                System.out.println("id:" + id + " ,name: " + name + ", year: " + year + ", model: " + model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}