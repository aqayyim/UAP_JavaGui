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
    public String getPhoneNumber() { return phoneNumber; }
    
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("\\d{10,15}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public static Doctor getDoctorById(String id) {
        return new Doctor(id, "Dr. Smith", "Cardiology", "Mon-Fri 9am-5pm", "1234567890");
    }

    public static Doctor[] getDoctors() {
        return new Doctor[] {
            new Doctor("D001", "Dr. Smith", "Cardiology", "Mon-Fri 9am-5pm", "1234567890"),
            new Doctor("D002", "Dr. Johnson", "Neurology", "Mon-Wed 10am-4pm", "2345678901")
        };
    }
}

