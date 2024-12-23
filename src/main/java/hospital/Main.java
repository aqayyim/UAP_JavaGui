package hospital;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import hospital.gui.MainFrame;
import hospital.service.UserService;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        
        SwingUtilities.invokeLater(() -> {
            UserService userService = new UserService();
            String username = userService.getLoggedInUsername();
            MainFrame mainFrame = new MainFrame();
            
            if (userService.isDoctor(username) || userService.isAdmin(username)) {
                mainFrame.enableDoctorFeatures();
            }
            
            mainFrame.setVisible(true);
        });
    }
}