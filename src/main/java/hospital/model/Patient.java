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
        this.phoneNumber = phoneNumber;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
