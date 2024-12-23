package hospital.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import hospital.exception.ValidationException;
import hospital.model.Patient;
import hospital.service.PatientService;

public class PatientPanel extends JPanel {
    private JTextField nameField;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JPanel dobPanel;
    private JTextField addressField;
    private JTextField phoneField;
    private JTable patientTable;
    private final PatientService patientService;
    private JButton addButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JTextField searchField;
    public String searchText;
    private JButton editButton;
    private int selectedPatientId = -1;

    public PatientPanel() {
        patientService = new PatientService();
        initComponents();
        setupLayout();
        addListeners();
    }
    
    private void initComponents() {
        // Initialize form fields
        nameField = createStyledTextField(20);
        addressField = createStyledTextField(30);
        phoneField = createStyledTextField(15);
        searchField = createStyledTextField(20);
        
        // Initialize date of birth components
        dayComboBox = new JComboBox<>(getDays());
        monthComboBox = new JComboBox<>(getMonths());
        yearComboBox = new JComboBox<>(getYears());
        
        // Style the combo boxes
        styleComboBox(dayComboBox);
        styleComboBox(monthComboBox);
        styleComboBox(yearComboBox);
        
        // Create DOB panel
        dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dobPanel.add(dayComboBox);
        dobPanel.add(new JLabel("/"));
        dobPanel.add(monthComboBox);
        dobPanel.add(new JLabel("/"));
        dobPanel.add(yearComboBox);
        
        // Initialize buttons with custom colors
        addButton = createStyledButton("Add Patient", new Color(46, 204, 113));
        deleteButton = createStyledButton("Delete", new Color(231, 76, 60));
        clearButton = createStyledButton("Clear", new Color(52, 73, 94));
        editButton = createStyledButton("Edit", new Color(52, 152, 219));
        
        // Initialize table
        patientTable = new JTable(patientService.getTableModel());
        patientTable.setRowHeight(25);
        patientTable.setShowGrid(true);
        patientTable.setGridColor(Color.BLACK);
        patientTable.getTableHeader().setBackground(new Color(52, 73, 94));
        patientTable.getTableHeader().setForeground(Color.BLACK);
        patientTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
    }
    
    private JTextField createStyledTextField(int columns) {
        JTextField field = new JTextField(columns);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        return field;
    }
    
    private void styleComboBox(JComboBox<String> comboBox) {
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox.setBackground(Color.BLACK);
        comboBox.setPreferredSize(new Dimension(
            comboBox == dayComboBox ? 60 : 
            comboBox == monthComboBox ? 60 : 
            100, // untuk year
            30));
    }
    
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
    
    private String[] getDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i-1] = String.format("%02d", i);
        }
        return days;
    }

    private String[] getMonths() {
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i-1] = String.format("%02d", i);
        }
        return months;
    }

    private String[] getYears() {
        String[] years = new String[100];
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(currentYear - i);
        }
        return years;
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        
        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        searchPanel.add(new JLabel("Search Patient: "));
        searchPanel.add(searchField);
        
        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(createStyledTitledBorder("Patient Information"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Add form components
        addFormField(formPanel, "Name:", nameField, gbc, 0);
        addFormField(formPanel, "Date of Birth:", dobPanel, gbc, 1);
        addFormField(formPanel, "Address:", addressField, gbc, 2);
        addFormField(formPanel, "Phone:", phoneField, gbc, 3);
        
        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(clearButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(buttonPanel, gbc);
        
        // Table Panel
        JScrollPane scrollPane = new JScrollPane(patientTable);
        scrollPane.setBorder(createStyledTitledBorder("Patient List"));
        
        // Main layout
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(searchPanel, BorderLayout.NORTH);
        topPanel.add(formPanel, BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private TitledBorder createStyledTitledBorder(String title) {
        return BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(52, 73, 94)), 
            title,
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14),
            new Color(52, 73, 94));
    }
    
    private void addFormField(JPanel panel, String label, JComponent field, 
                            GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(label), gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(field, gbc);
    }
    
    private void addListeners() {
        addButton.addActionListener(e -> addPatient());
        clearButton.addActionListener(e -> clearForm());
        deleteButton.addActionListener(e -> deletePatient());
        editButton.addActionListener(e -> editPatient());

        patientTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelectedPatient();
            }
        });

        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { search(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { search(); }
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { search(); }
        });
    }
    
    private void addPatient() {
        try {
            validateInput();
            String dateOfBirth = String.format("%s/%s/%s",
                dayComboBox.getSelectedItem(),
                monthComboBox.getSelectedItem(),
                yearComboBox.getSelectedItem());
                
            Patient patient = new Patient(
                null,
                nameField.getText().trim(),
                dateOfBirth,
                addressField.getText().trim(),
                phoneField.getText().trim()
            );
            patientService.addPatient(patient);
            clearForm();
            JOptionPane.showMessageDialog(this,
                "Patient added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                ex.getMessage(),
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deletePatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this patient?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                patientService.deletePatient(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Please select a patient to delete",
                "No Selection",
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void search() {
        searchText = searchField.getText().toLowerCase();
    }
    
    private void validateInput() throws ValidationException {
        if (nameField.getText().trim().isEmpty()) {
            throw new ValidationException("Name is required");
        }
        if (addressField.getText().trim().isEmpty()) {
            throw new ValidationException("Address is required");
        }
        if (phoneField.getText().trim().isEmpty()) {
            throw new ValidationException("Phone number is required");
        }
        if (!phoneField.getText().trim().matches("\\d{10,12}")) {
            throw new ValidationException("Phone number must be between 10-12 digits");
        }
    }
    
    private void clearForm() {
        nameField.setText("");
        dayComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        addressField.setText("");
        phoneField.setText("");
        nameField.requestFocus();
        selectedPatientId = -1;
    }

    private void loadSelectedPatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow >= 0) {
            Patient patient = patientService.getPatientAt(selectedRow);
            selectedPatientId = Integer.parseInt(patient.getId());
            nameField.setText(patient.getName());
            // Parse and set date of birth
            String[] dobParts = patient.getDateOfBirth().split("/");
            dayComboBox.setSelectedItem(dobParts[0]);
            monthComboBox.setSelectedItem(dobParts[1]);
            yearComboBox.setSelectedItem(dobParts[2]);
            addressField.setText(patient.getAddress());
            phoneField.setText(patient.getPhone());
        }
    }

    private void editPatient() {
        if (selectedPatientId >= 0) {
            try {
                validateInput();
                String dateOfBirth = String.format("%s/%s/%s",
                    dayComboBox.getSelectedItem(),
                    monthComboBox.getSelectedItem(),
                    yearComboBox.getSelectedItem());

                Patient patient = new Patient(
                    String.valueOf(selectedPatientId),
                    nameField.getText().trim(),
                    dateOfBirth,
                    addressField.getText().trim(),
                    phoneField.getText().trim()
                );
                patientService.updatePatient(selectedPatientId, patient);
                clearForm();
                JOptionPane.showMessageDialog(this,
                    "Patient updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (ValidationException ex) {
                JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Please select a patient to edit",
                "No Selection",
                JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setViewOnlyMode(boolean viewOnly) {
        addButton.setEnabled(!viewOnly);
        editButton.setEnabled(!viewOnly);
        deleteButton.setEnabled(!viewOnly);
    }
}