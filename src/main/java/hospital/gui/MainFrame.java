// hospital/gui/MainFrame.java
package hospital.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.Timer;

import hospital.login.LoginDialog;


public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private PatientPanel patientPanel;
    private DoctorPanel doctorPanel;
    private JLabel timeLabel;


    public static void showApplication() {
        // Buat frame tapi jangan tampilkan dulu
        MainFrame frame = new MainFrame();
        
        // Tampilkan login dialog
        LoginDialog loginDialog = new LoginDialog(frame);
        loginDialog.setVisible(true);
        
        // Cek hasil login
        if (loginDialog.isAuthenticated()) {
            // Jika login berhasil, tampilkan main frame
            frame.setVisible(true);
        } else {
            // Jika login gagal, keluar dari aplikasi
            System.exit(0);
        }
    }
    public MainFrame() {
        // Hapus try-catch showLoginDialog() dari sini
        initComponents();
        setupLayout();
        customizeAppearance();
    }

    public void enableDoctorFeatures() {
        // Enable editing features for both patient and doctor panels
        patientPanel.setViewOnlyMode(false);
        doctorPanel.setViewOnlyMode(false);
    }

    private void initComponents() {
        setTitle("Cowmam's Clinic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Create header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));

        // Create clinic name label
        JLabel clinicName = new JLabel("Cowmam's Clinic");
        clinicName.setFont(new Font("Arial", Font.BOLD, 28));
        clinicName.setForeground(Color.WHITE);
        clinicName.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));

        // Add sub-title
        JLabel subTitle = new JLabel("Healthcare Management System");
        subTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitle.setForeground(new Color(236, 240, 241));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setBackground(new Color(41, 128, 185));
        titlePanel.add(clinicName);
        titlePanel.add(subTitle);

        headerPanel.add(titlePanel, BorderLayout.WEST);

        // Initialize tabs
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));

        patientPanel = new PatientPanel();
        doctorPanel = new DoctorPanel();

        // Menambahkan tab tanpa icon
        tabbedPane.addTab("Patients", patientPanel);
        tabbedPane.addTab("Doctors", doctorPanel);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Create main header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));
        
        // Left side: Clinic name and subtitle
        JLabel clinicName = new JLabel("Cowmam's Clinic");
        clinicName.setFont(new Font("Arial", Font.BOLD, 28));
        clinicName.setForeground(Color.WHITE);
        clinicName.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
        
        JLabel subTitle = new JLabel("Healthcare Management System");
        subTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitle.setForeground(new Color(236, 240, 241));
        
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setBackground(new Color(41, 128, 185));
        titlePanel.add(clinicName);
        titlePanel.add(subTitle);
        
        headerPanel.add(titlePanel, BorderLayout.WEST);
        
        // Right side: Date and Time in vertical layout
        JPanel dateTimePanel = new JPanel(new GridLayout(2, 1));
        dateTimePanel.setBackground(new Color(41, 128, 185));
        dateTimePanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 25, 20));
        
        // Date Label
        JLabel dateLabel = new JLabel(new java.text.SimpleDateFormat("dd MMMM yyyy").format(new java.util.Date()));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        // Time Label setup
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        // Add timer for updating time
        new Timer(1000, e -> {
            java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("HH:mm:ss z");
            timeFormat.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Jakarta"));
            timeLabel.setText(timeFormat.format(new java.util.Date()));
        }).start();
        
        dateTimePanel.add(dateLabel);
        dateTimePanel.add(timeLabel);
        
        headerPanel.add(dateTimePanel, BorderLayout.EAST);
        
        // Add components to frame
        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        
        // Add status bar
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel statusLabel = new JLabel("Welcome to Cowmam's Clinic Management System");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusBar.add(statusLabel);
        add(statusBar, BorderLayout.SOUTH);
    }

    private void customizeAppearance() {
        // Set custom colors for tabs
        tabbedPane.setBackground(new Color(236, 240, 241));
        tabbedPane.setForeground(new Color(44, 62, 80));

        // Add padding
        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Custom UI elements
        UIManager.put("Button.background", new Color(52, 152, 219));
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 12));

        // Make window not resizable
        setResizable(false);
    }
}