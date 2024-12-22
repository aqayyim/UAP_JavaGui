package hospital.service;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import hospital.model.Patient;

public class PatientService {
    private List<Patient> patients;
    private DefaultTableModel tableModel;
    private static final String DATA_FILE = "patients.dat";

    public PatientService() {
        patients = new ArrayList<>();
        initializeTableModel();
        loadData();
    }

    private void initializeTableModel() {
        String[] columns = {"ID", "Name", "Date of Birth", "Address", "Phone"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
