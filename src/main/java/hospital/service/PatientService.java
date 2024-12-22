private void addToTable(Patient patient) {
    tableModel.addRow(new Object[]{
        patient.getId(),
        patient.getName(),
        patient.getDateOfBirth(),
        patient.getAddress(),
        patient.getPhoneNumber()
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
            patients = (List<Patient>) obj;
            updateTable();
        }
    } catch (Exception e) {
        System.err.println("Error loading data: " + e.getMessage());
        patients = new ArrayList<>();
    }
}

private void saveData() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
        oos.writeObject(patients);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, 
            "Error saving data: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

private void updateTable() {
    tableModel.setRowCount(0);
    for (Patient patient : patients) {
        addToTable(patient);
    }
}

public DefaultTableModel getTableModel() {
    return tableModel;
}

public void deletePatient(int selectedRow) {
    if (selectedRow >= 0 && selectedRow < patients.size()) {
        patients.remove(selectedRow);
        tableModel.removeRow(selectedRow);
        saveData();
    }
}


public void updatePatient(int selectedRow, Patient updatedPatient) {
    if (selectedRow >= 0 && selectedRow < patients.size()) {
        updatedPatient.setId(patients.get(selectedRow).getId());
        patients.set(selectedRow, updatedPatient);
        updateTable();
        saveData();
    }
}
