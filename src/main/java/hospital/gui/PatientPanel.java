package hospital.gui;

import java.awt.*;
import javax.swing.*;

public class PatientPanel extends JPanel {
    public PatientPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Patient Panel"), BorderLayout.CENTER);
    }
}
