package hospital.service;

public class UserService {
    
    public String getLoggedInUsername() {
        return "admin";
    }

    public boolean isDoctor(String username) {
        return "doctor".equals(username);
    }

    public boolean isAdmin(String username) {
        return "admin".equals(username);
    }

    public boolean isPatient(String username) {
        return true; // Placeholder
    }
    
}
