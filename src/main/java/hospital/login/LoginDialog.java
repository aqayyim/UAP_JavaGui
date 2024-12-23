package hospital.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
   private Map<String, String> userDatabase;
   private boolean authenticated;

   public LoginDialog(JFrame parent) {
       super(parent, "Login", true);
       initComponents();
       setupLayout();
       setupListeners();
       initializeDatabase();
       authenticated = false;
       pack();
       setLocationRelativeTo(parent);
       setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
       });
   }

   private void initComponents() {
       usernameField = new JTextField(20);
       passwordField = new JPasswordField(20);
       loginButton = new JButton("Login");
       cancelButton = new JButton("Cancel");
       
       // Set default button
       getRootPane().setDefaultButton(loginButton);
   }

   private void setupLayout() {
       setLayout(new BorderLayout());
       
       // Header panel with title
       JPanel headerPanel = new JPanel();
       headerPanel.setBackground(new Color(41, 128, 185));
       headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
       
       JLabel titleLabel = new JLabel("Cowmam's Clinic");
       titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
       titleLabel.setForeground(Color.WHITE);
       
       JLabel subtitleLabel = new JLabel("Login to Access System");
       subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
       subtitleLabel.setForeground(new Color(236, 240, 241));
       
       JPanel titlePanel = new JPanel(new BorderLayout());
       titlePanel.setBackground(new Color(41, 128, 185));
       titlePanel.add(titleLabel, BorderLayout.NORTH);
       titlePanel.add(subtitleLabel, BorderLayout.SOUTH);
       headerPanel.add(titlePanel);
       
       // Input panel
       JPanel inputPanel = new JPanel(new GridBagLayout());
       inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
       
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(5, 5, 5, 5);
       gbc.anchor = GridBagConstraints.WEST;
       
       // Username field
       gbc.gridx = 0;
       gbc.gridy = 0;
       JLabel usernameLabel = new JLabel("Username:");
       usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
       inputPanel.add(usernameLabel, gbc);
       
       gbc.gridx = 1;
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.weightx = 1.0;
       usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
       inputPanel.add(usernameField, gbc);
       
       // Password field
       gbc.gridx = 0;
       gbc.gridy = 1;
       gbc.weightx = 0;
       JLabel passwordLabel = new JLabel("Password:");
       passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
       inputPanel.add(passwordLabel, gbc);
       
       gbc.gridx = 1;
       gbc.weightx = 1.0;
       passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
       inputPanel.add(passwordField, gbc);
       
       // Button panel
       JPanel buttonPanel = new JPanel();
       buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 20, 25));
       
       cancelButton.setFont(new Font("Arial", Font.BOLD, 12));
       loginButton.setFont(new Font("Arial", Font.BOLD, 12));
       
       // Style the buttons
       loginButton.setBackground(new Color(41, 128, 185));
       loginButton.setForeground(Color.BLACK);
       loginButton.setFocusPainted(false);
       
       cancelButton.setBackground(new Color(189, 195, 199));
       cancelButton.setForeground(Color.BLACK);
       cancelButton.setFocusPainted(false);
       
       buttonPanel.add(cancelButton);
       buttonPanel.add(loginButton);
       
       // Add all panels to dialog
       add(headerPanel, BorderLayout.NORTH);
       add(inputPanel, BorderLayout.CENTER);
       add(buttonPanel, BorderLayout.SOUTH);
   }

   private void setupListeners() {
       loginButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               performLogin();
           }
       });
       
       cancelButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
       
       // Add key listeners for better user experience
       KeyListener keyListener = new KeyListener() {
           @Override
           public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   performLogin();
               }
           }
           
           @Override
           public void keyTyped(KeyEvent e) {}
           
           @Override
           public void keyReleased(KeyEvent e) {}
       };
       
       usernameField.addKeyListener(keyListener);
       passwordField.addKeyListener(keyListener);
   }

   private void initializeDatabase() {
       userDatabase = new HashMap<>();
       userDatabase.put("admin123", "admin123");
       userDatabase.put("user123", "user123");
   }

   private void performLogin() {
       String username = usernameField.getText();
       String password = new String(passwordField.getPassword());
       
       if (validateLogin(username, password)) {
           authenticated = true;
           dispose();
       } else {
           JOptionPane.showMessageDialog(
               LoginDialog.this,
               "Invalid username or password",
               "Login Failed",
               JOptionPane.ERROR_MESSAGE
           );
           passwordField.setText("");
           passwordField.requestFocus();
       }
   }

   private boolean validateLogin(String username, String password) {
       String storedPassword = userDatabase.get(username);
       return storedPassword != null && storedPassword.equals(password);
   }

   public boolean isAuthenticated() {
       return authenticated;
   }
}