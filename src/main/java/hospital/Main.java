package hospital;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import hospital.gui.MainFrame;
import hospital.login.LoginDialog;
import hospital.service.UserService;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            // Buat temporary frame untuk parent dari login dialog
            JFrame tempFrame = new JFrame();

            // Tampilkan login dialog
            LoginDialog loginDialog = new LoginDialog(tempFrame);
            loginDialog.setVisible(true);

            // Cek hasil login
            if (loginDialog.isAuthenticated()) {
                UserService userService = new UserService();
                String username = userService.getLoggedInUsername();
                MainFrame mainFrame = new MainFrame();

                if (userService.isDoctor(username) || userService.isAdmin(username)) {
                    mainFrame.enableDoctorFeatures();
                }

                mainFrame.setVisible(true);
            } else {
                System.exit(0);
            }

            // Hapus temporary frame
            tempFrame.dispose();
        });
    }
}