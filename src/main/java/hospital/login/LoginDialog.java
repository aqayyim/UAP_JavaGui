package hospital.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private Map<String, String> doctorDatabase;
    private Map<String, String> patientDatabase;
    private boolean authenticated;

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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform login validation here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (validateLogin(username, password)) {
                    authenticated = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginDialog.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void initializeDatabases() {
        doctorDatabase = new HashMap<>();
        doctorDatabase.put("admin123", "admin123");

        patientDatabase = new HashMap<>();
        patientDatabase.put("user123", "user123");
    }

    private boolean validateLogin(String username, String password) {
        // Check in doctor database
        if (doctorDatabase.containsKey(username) && doctorDatabase.get(username).equals(password)) {
            return true;
        }
        // Check in patient database
        if (patientDatabase.containsKey(username) && patientDatabase.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
