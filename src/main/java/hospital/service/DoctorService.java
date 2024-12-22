package hospital.service;

import hospital.model.Doctor;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class DoctorService {
    private List<Doctor> doctors;
    private DefaultTableModel tableModel;
    private static final String DATA_FILE = "doctors.dat";
    
    public DoctorService() {
        doctors = new ArrayList<>();
        initializeTableModel();
        loadData();
    }
    
    private void initializeTableModel() {
        String[] columns = {"ID", "Name", "Specialization", "Schedule", "Phone"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public void addDoctor(Doctor doctor) {
        try {
            String id = String.format("D%03d", doctors.size() + 1);
            doctor.setId(id);
            doctors.add(doctor);
            addToTable(doctor);
            saveData();
            JOptionPane.showMessageDialog(null, 
                "Doctor added successfully", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error adding doctor: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Menambahkan dokter ke dalam tabel
    private void addToTable(Doctor doctor) {
        tableModel.addRow(new Object[]{
            doctor.getId(), doctor.getName(), doctor.getSpecialization(), doctor.getSchedule(), doctor.getPhoneNumber()
        });
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                doctors = (List<Doctor>) obj;
                updateTable();
            }
        } catch (Exception e) {
            doctors = new ArrayList<>();
        }
    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(doctors);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saving data: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Doctor doctor : doctors) {
            addToTable(doctor);
        }
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void deleteDoctor(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < doctors.size()) {
            doctors.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            saveData();
        }
    }

    public void updateDoctor(int selectedRow, Doctor updatedDoctor) {
        if (selectedRow >= 0 && selectedRow < doctors.size()) {
            updatedDoctor.setId(doctors.get(selectedRow).getId());
            doctors.set(selectedRow, updatedDoctor);
            updateTable();
            saveData();
        }
    }
}
