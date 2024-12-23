package hospital.service;

public class UserService {
    
    public String getLoggedInUsername() {
        // Logic to get the logged-in username from the database
        // For example:
        return "admin"; // Placeholder
    }

    public boolean isDoctor(String username) {
        // Logic to check if the user is a doctor
        // For example:
        return "doctor".equals(username);
    }

    public boolean isAdmin(String username) {
        // Logic to check if the user is an admin
        // For example:
        return "admin".equals(username);
    }
    
}
