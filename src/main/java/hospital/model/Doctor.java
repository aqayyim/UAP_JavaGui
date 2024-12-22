package hospital.model;

public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private String schedule;
    private String phoneNumber;

    // Constructor untuk inisialisasi objek Doctor
    public Doctor(String id, String name, String specialization, String schedule, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.schedule = schedule;
        this.phoneNumber = phoneNumber;
    }

    // Getter dan setter untuk id
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // Getter dan setter untuk atribut lainnya
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
