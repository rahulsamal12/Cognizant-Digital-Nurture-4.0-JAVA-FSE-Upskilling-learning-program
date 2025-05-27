import java.sql.*;

public class TransactionExample {

    static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    static final String USER = "root";
    static final String PASS = "2024";

    public static void transferMoney(int fromId, int toId, double amount) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();

            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();
            conn.commit(); 
            System.out.println("Transaction successful!");

        } catch (Exception e) {
            System.out.println("Transaction failed. Rolling back...");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true); 
                if (conn != null) conn.close();             
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        transferMoney(1, 2, 200);
    }
}
