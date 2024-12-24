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
import javax.swing.Timer;
import javax.swing.UIManager;

import hospital.login.LoginDialog;


public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private PatientPanel patientPanel;
    private DoctorPanel doctorPanel;
    private JLabel timeLabel;


    public static void showApplication() {
        MainFrame frame = new MainFrame();
        
        LoginDialog loginDialog = new LoginDialog(frame);
        loginDialog.setVisible(true);
        
        if (loginDialog.isAuthenticated()) {
            frame.setVisible(true);
        } else {
            System.exit(0);
        }
    }
    public MainFrame() {
        initComponents();
        setupLayout();
        customizeAppearance();
    }

    public void enableDoctorFeatures() {
        patientPanel.setViewOnlyMode(false);
        doctorPanel.setViewOnlyMode(false);
        doctorPanel.setEnabled(true);
        // ...additional code to enable features...
    }

    public void disableDoctorPanelEditing() {
        doctorPanel.setEnabled(false);
        // ...additional code to disable features...
    }

    private void initComponents() {
        setTitle("Cowmam's Clinic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));

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

        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));

        patientPanel = new PatientPanel();
        doctorPanel = new DoctorPanel();

        tabbedPane.addTab("Patients", patientPanel);
        tabbedPane.addTab("Doctors", doctorPanel);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));
        
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
        
        JPanel dateTimePanel = new JPanel(new GridLayout(2, 1));
        dateTimePanel.setBackground(new Color(41, 128, 185));
        dateTimePanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 25, 20));
        
        JLabel dateLabel = new JLabel(new java.text.SimpleDateFormat("dd MMMM yyyy").format(new java.util.Date()));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        new Timer(1000, e -> {
            java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("HH:mm:ss z");
            timeFormat.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Jakarta"));
            timeLabel.setText(timeFormat.format(new java.util.Date()));
        }).start();
        
        dateTimePanel.add(dateLabel);
        dateTimePanel.add(timeLabel);
        
        headerPanel.add(dateTimePanel, BorderLayout.EAST);
        
        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel statusLabel = new JLabel("Welcome to Cowmam's Clinic Management System");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusBar.add(statusLabel);
        add(statusBar, BorderLayout.SOUTH);
    }

    private void customizeAppearance() {
        tabbedPane.setBackground(new Color(236, 240, 241));
        tabbedPane.setForeground(new Color(44, 62, 80));

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