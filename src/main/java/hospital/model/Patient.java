package hospital.model;

public class Patient {
    private String id;
    private String name;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;

    public Patient(String id, String name, String dateOfBirth, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        setPhoneNumber(phoneNumber);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("\\d{10,15}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public static Patient getPatientById(String id) {
        return new Patient(id, "John Doe", "01/01/1990", "123 Main St", "1234567890"),
        new Patient("P002", "Jane Smith", "02/02/1985", "456 Elm St", "2345678901");
    }


    public static Patient getPatientById(String id) {
        for (Patient patient : getPatients()) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }
}

