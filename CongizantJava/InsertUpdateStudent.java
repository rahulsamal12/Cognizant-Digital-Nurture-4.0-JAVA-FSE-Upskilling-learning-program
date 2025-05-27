import java.sql.*;

public class InsertUpdateStudent {
    private Connection conn;

    public InsertUpdateStudent() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "2024");
    }

    public void insertStudent(int id, String name) throws SQLException {
        String query = "INSERT INTO students (id, name) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
        System.out.println("Inserted student.");
    }

    public void updateStudent(int id, String newName) throws SQLException {
        String query = "UPDATE students SET name = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, newName);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Updated student.");
    }

    public static void main(String[] args) throws Exception {
        InsertUpdateStudent dao = new InsertUpdateStudent();
        dao.insertStudent(3, "Ravi");
        dao.updateStudent(3, "Ravi Kumar");
    }
}
