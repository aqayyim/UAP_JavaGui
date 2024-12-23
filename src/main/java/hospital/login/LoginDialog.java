package hospital.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private Map<String, String> doctorDatabase;
    private Map<String, String> patientDatabase;
    private boolean authenticated;
    private String userRole;

    public LoginDialog(JFrame parent) {
        super(parent, "Login", true);
        initComponents();
        setupLayout();
        setupListeners();
        initializeDatabases();
        authenticated = false;
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(cancelButton);
        add(panel, BorderLayout.CENTER);
    }

    private void setupListeners() {
        loginButton.addActionListener(e -> {
            // Perform login validation here
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (validateLogin(username, password)) {
                authenticated = true;
                userRole = getUserRoleFromDatabase(username);
                dispose();
                showMainPanel(userRole);
            } else {
                JOptionPane.showMessageDialog(LoginDialog.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> System.exit(0));
    }

    private void initializeDatabases() {
        doctorDatabase = new HashMap<>();
        doctorDatabase.put("admin123", "admin123");

        patientDatabase = new HashMap<>();
        patientDatabase.put("user123", "user123");
    }

    private boolean validateLogin(String username, String password) {
        // Check in doctor and patient databases
        return (doctorDatabase.containsKey(username) && doctorDatabase.get(username).equals(password)) ||
               (patientDatabase.containsKey(username) && patientDatabase.get(username).equals(password));
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getUserRole() {
        return userRole;
    }

    private String getUserRoleFromDatabase(String username) {
        if (doctorDatabase.containsKey(username)) {
            return "Doctor";
        } else if (patientDatabase.containsKey(username)) {
            return "Patient";
        }
        return "Unknown";
    }

    private void showMainPanel(String role) {
        switch (role) {
            case "Doctor":
                // Show doctor main panel
                JOptionPane.showMessageDialog(this, "Welcome Doctor!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Patient":
                // Show patient main panel
                JOptionPane.showMessageDialog(this, "Welcome Patient!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Unknown role!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}
