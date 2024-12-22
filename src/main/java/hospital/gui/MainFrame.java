package hospital.gui;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Cowmam's Clinic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        
                // Header Panel setup
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));
        
        JLabel clinicName = new JLabel("Cowmam's Clinic");
        clinicName.setFont(new Font("Arial", Font.BOLD, 28));
        clinicName.setForeground(Color.WHITE);
        
        JLabel subTitle = new JLabel("Healthcare Management System");
        subTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitle.setForeground(new Color(236, 240, 241));
        
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.add(clinicName);
        titlePanel.add(subTitle);
        
        headerPanel.add(titlePanel, BorderLayout.WEST);
        
        // TabbedPane for Patients and Doctors
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Patients", new JPanel());
        tabbedPane.addTab("Doctors", new JPanel());
        
        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }
}
        // Header Panel setup
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(41, 128, 185));
        
        JLabel clinicName = new JLabel("Cowmam's Clinic");
        clinicName.setFont(new Font("Arial", Font.BOLD, 28));
        clinicName.setForeground(Color.WHITE);
        
        JLabel subTitle = new JLabel("Healthcare Management System");
        subTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitle.setForeground(new Color(236, 240, 241));
        
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.add(clinicName);
        titlePanel.add(subTitle);
        
        headerPanel.add(titlePanel, BorderLayout.WEST);
        
        // TabbedPane for Patients and Doctors
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Patients", new JPanel());
        tabbedPane.addTab("Doctors", new JPanel());
        
        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

        // Status bar
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        JLabel statusLabel = new JLabel("Welcome to Cowmam's Clinic Management System");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusBar.add(statusLabel);
        
        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);


        // Appearance Customization
        tabbedPane.setBackground(new Color(236, 240, 241));
        tabbedPane.setForeground(new Color(44, 62, 80));
        
        UIManager.put("Button.background", new Color(52, 152, 219));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 12));
        
        setResizable(false);
    }
}

