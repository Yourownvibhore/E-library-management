import java.sql.*;

public class EmployeeInfoDisplay {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/vib";
        String username = "root";
        String password = "1857";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_id, age, first_name, last_name FROM employees");

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                int age = resultSet.getInt("age");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                System.out.println("Employee ID: " + employeeId);
                System.out.println("Age: " + age);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("--------------------");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
