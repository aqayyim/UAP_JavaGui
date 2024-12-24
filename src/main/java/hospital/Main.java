package hospital;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import hospital.gui.MainFrame;
import hospital.login.LoginDialog;
import hospital.service.UserService;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            JFrame tempFrame = new JFrame();

            LoginDialog loginDialog = new LoginDialog(tempFrame);
            loginDialog.setVisible(true);

            if (loginDialog.isAuthenticated()) {
                UserService userService = new UserService();
                String username = userService.getLoggedInUsername();
                MainFrame mainFrame = new MainFrame();

                if (userService.isDoctor(username) || userService.isAdmin(username)) {
                    mainFrame.enableDoctorFeatures();
                } else if (userService.isPatient(username)) {
                    mainFrame.disableDoctorPanelEditing();
                }

                mainFrame.setVisible(true);
            } else {
                System.exit(0);
            }

            tempFrame.dispose();
        });
    }
}