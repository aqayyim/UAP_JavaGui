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
