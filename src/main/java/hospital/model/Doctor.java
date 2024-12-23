package hospital.model;

import java.io.Serializable;

public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
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
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPhone() {
        throw new UnsupportedOperationException("Unimplemented method 'getPhone'");
    }

}