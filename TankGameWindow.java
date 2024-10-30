package Project2Demoa;

import javax.swing.*;

public class TankGameWindow {
    public TankGameWindow() {
        MainFrame app = new MainFrame();
        app.setTitle("Tank Game");
        app.setSize(600, 600);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null); // Center the window
        app.add(new TankGamePanel()); // Add the game panel
        app.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
    }
}


