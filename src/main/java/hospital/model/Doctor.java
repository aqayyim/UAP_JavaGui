package hospital.model;

public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private String schedule;
    private String phoneNumber;
    
    public Doctor(String id, String name, String specialization, String schedule, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.schedule = schedule;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
