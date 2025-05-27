import java.sql.*;
public class BasicJDBCConnection {

	static final String URL = "jdbc:mysql://localhost:3306/school";
    static final String USER = "root";
    static final String PASSWORD = "2024";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (name VARCHAR(255), age INT, email VARCHAR(255))");

            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO students (name, age, email) VALUES (?, ?, ?)");
            insertStmt.setString(1, "Sourav raut");
            insertStmt.setInt(2, 22);
            insertStmt.setString(3, "sourav@gmail.com");
            insertStmt.executeUpdate();

            PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = selectStmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name") + ", " + rs.getInt("age") + ", " + rs.getString("email"));
            }

            PreparedStatement updateStmt = conn.prepareStatement("UPDATE students SET age = ? WHERE name = ?");
            updateStmt.setInt(1, 35);
            updateStmt.setString(2, "Sourav raut");
            updateStmt.executeUpdate();

            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM students WHERE name = ?");
            deleteStmt.setString(1, "Sourav raut");
            deleteStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}