package hospital.gui;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Cowmam's Clinic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        
        // Header panel with title and subtitle
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
        add(headerPanel, BorderLayout.NORTH);
    }
}
