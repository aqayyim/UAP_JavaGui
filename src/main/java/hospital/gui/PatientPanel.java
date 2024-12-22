package hospital.gui;

import javax.swing.*;
import java.awt.*;

public class PatientPanel extends JPanel {
    private JTable patientTable;

    public PatientPanel() {
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        patientTable = new JTable(10, 5);  // Dummy table model for example
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        JScrollPane scrollPane = new JScrollPane(patientTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}
