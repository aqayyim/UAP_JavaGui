package hospital.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private DoctorPanel doctorPanel;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        doctorPanel = new DoctorPanel();
        add(doctorPanel);
        setTitle("Hospital Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
