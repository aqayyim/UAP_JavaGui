package hospital.gui;

import java.awt.AWTError;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DoctorPanel extends JPanel {
    private final JButton someButton;
    private final JLabel someLabel;

    public DoctorPanel() {
        // Initialize components
        someButton = new JButton("Click Me");
        someLabel = new JLabel("Doctor Panel");

        // Call setupLayout after initializing components
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        // Debug statements to check for null components
        if (someButton == null) {
            System.err.println("someButton is null");
        }
        if (someLabel == null) {
            System.err.println("someLabel is null");
        }
        // Ensure components are not null before adding
        if (someButton != null) {
            add(someButton, BorderLayout.CENTER);
        }
        if (someLabel != null) {
            add(someLabel, BorderLayout.NORTH);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DoctorPanel());
                frame.pack();
                frame.setVisible(true);
            } catch (HeadlessException | AWTError e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        });
    }
}
