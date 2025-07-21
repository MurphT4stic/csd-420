//Tabari Harvey, Module-10 Programming Assignment CSD420
import java.sql.*;

public class FanAppTest {

    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb?serverTimezone=UTC";
    private final String USER = "student1";
    private final String PASS = "pass";

    public static void main(String[] args) {
        FanAppTest test = new FanAppTest();
        test.testDisplayExistingID(101); // Try a known ID
        test.testUpdateRecord(102);      // Try updating another known ID
    }

    public void testDisplayExistingID(int id) {
        System.out.println("🔍 Testing Display for ID: " + id);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("✅ Found record:");
                System.out.println("  Name: " + rs.getString("firstname") + " " + rs.getString("lastname"));
                System.out.println("  Team: " + rs.getString("favoriteteam"));
            } else {
                System.out.println("❌ No record found for ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testUpdateRecord(int id) {
        System.out.println("🛠️ Testing Update for ID: " + id);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?")) {

            stmt.setString(1, "UpdatedFirst");
            stmt.setString(2, "UpdatedLast");
            stmt.setString(3, "UpdatedTeam");
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Successfully updated record for ID: " + id);
            } else {
                System.out.println("❌ Failed to update record for ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
