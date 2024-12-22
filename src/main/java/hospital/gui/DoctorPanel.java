package hospital.gui;

import javax.swing.*;
import java.awt.*;
import hospital.service.DoctorService;

private JTextField nameField;
private JTextField specializationField;
private JTextField phoneField;

public DoctorPanel() {
    doctorService = new DoctorService();
    initComponents();
    setupLayout();
    addListeners();
}

private void initComponents() {
    nameField = new JTextField(20);
    specializationField = new JTextField(20);
    phoneField = new JTextField(15);
}
