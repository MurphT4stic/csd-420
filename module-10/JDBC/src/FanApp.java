//Tabari Harvey, Module 10 programming assignment CSD420
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FanApp extends JFrame {
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayBtn, updateBtn;

    // JDBC root access for setup
    private final String ROOT_URL = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
    private final String ROOT_USER = "root"; // CHANGE THIS if you're not using root
    private final String ROOT_PASS = "rootpassword"; // CHANGE THIS to your root password

    // Application credentials
    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb?serverTimezone=UTC";
    private final String USER = "student1";
    private final String PASS = "pass";

    public FanApp() {
        setTitle("Fan Viewer & Updater");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridLayout(6, 2));

        // GUI Inputs
        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Favorite Team:"));
        favoriteTeamField = new JTextField();
        add(favoriteTeamField);

        displayBtn = new JButton("Display");
        updateBtn = new JButton("Update");

        add(displayBtn);
        add(updateBtn);

        displayBtn.addActionListener(e -> displayRecord());
        updateBtn.addActionListener(e -> updateRecord());

        // Setup database once before showing GUI
        setupDatabase();

        setVisible(true);
    }

    private void setupDatabase() {
        try (Connection conn = DriverManager.getConnection(ROOT_URL, ROOT_USER, ROOT_PASS);
             Statement stmt = conn.createStatement()) {

            // Create DB and user if not exist
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS databasedb;");
            stmt.executeUpdate("CREATE USER IF NOT EXISTS 'student1'@'localhost' IDENTIFIED BY 'pass';");
            stmt.executeUpdate("GRANT ALL PRIVILEGES ON databasedb.* TO 'student1'@'localhost';");

            // Connect as student1 to create table and insert data
            try (Connection userConn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement userStmt = userConn.createStatement()) {

                userStmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS fans (
                        ID INT PRIMARY KEY,
                        firstname VARCHAR(25),
                        lastname VARCHAR(25),
                        favoriteteam VARCHAR(25)
                    );
                """);

                // Insert sample data (ignore duplicates using INSERT IGNORE)
                userStmt.executeUpdate("""
                    INSERT IGNORE INTO fans (ID, firstname, lastname, favoriteteam) VALUES
                    (101, 'Derrick', 'Henry', 'Ravens'),
                    (102, 'Josh', 'Jacobs', 'Packers'),
                    (103, 'Shoei', 'Otani', 'Dodgers'),
                    (104, 'Steph', 'Curry', 'Warriors'),
                    (105, 'Chris', 'Bosh', 'Heat');
                """);
            }

            System.out.println("Database setup complete.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database setup failed. Check root credentials or server.");
        }
    }

    private void displayRecord() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

            int id = Integer.parseInt(idField.getText());
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateRecord() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("""
                 UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?
             """)) {

            int id = Integer.parseInt(idField.getText());
            stmt.setString(1, firstNameField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setString(3, favoriteTeamField.getText());
            stmt.setInt(4, id);

            int result = stmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "No record updated.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            SwingUtilities.invokeLater(FanApp::new);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
