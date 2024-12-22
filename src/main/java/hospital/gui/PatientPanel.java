package hospital.gui;

import javax.swing.*;
import java.awt.*;

public class PatientPanel extends JPanel {
    private JTextField nameField;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField addressField;
    private JTextField phoneField;

    public PatientPanel() {
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        nameField = new JTextField(20);
        addressField = new JTextField(30);
        phoneField = new JTextField(15);
        dayComboBox = new JComboBox<>(getDays());
        monthComboBox = new JComboBox<>(getMonths());
        yearComboBox = new JComboBox<>(getYears());
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        add(nameField, BorderLayout.NORTH);
        add(addressField, BorderLayout.CENTER);
    }

    private String[] getDays() {
        return new String[] {"01", "02", "03"};
    }

    private String[] getMonths() {
        return new String[] {"01", "02", "03"};
    }

    private String[] getYears() {
        return new String[] {"2020", "2021", "2022"};
    }
}
