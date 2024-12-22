public void addPatient(Patient patient) {
    try {
        String id = String.format("P%03d", patients.size() + 1);
        patient.setId(id);
        patients.add(patient);
        addToTable(patient);
        saveData();
        JOptionPane.showMessageDialog(null, 
            "Patient added successfully", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "Error adding patient: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
