package hospital.gui;

import javax.swing.*;
import java.awt.*;

public class PatientPanel extends JPanel {
    private JButton addButton;
    private JButton clearButton;

    public PatientPanel() {
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        addButton = new JButton("Add Patient");
        clearButton = new JButton("Clear");
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
