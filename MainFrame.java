package Project2Demoa;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        // Set the properties for the main frame
        setTitle("Tank Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        add(new TankGamePanel()); // Add your game panel here
    }
}
