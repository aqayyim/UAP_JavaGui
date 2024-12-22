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
