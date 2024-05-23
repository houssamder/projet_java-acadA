import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/javacode";
        String user = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    /*public static void setupDatabase(Connection conn, String sqlFilePath) {
        try {
            Statement stmt = conn.createStatement();
            BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String[] commands = sb.toString().split(";");

            for (String command : commands) {
                stmt.executeUpdate(command);
            }

            System.out.println("Database setup completed.");

            reader.close();
            stmt.close();
        } catch (IOException | SQLException e) {
            System.out.println("Error setting up database: " + e.getMessage());
        }
    }*/
}
