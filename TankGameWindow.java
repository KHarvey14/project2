package proj2;

import javax.swing.*;

public class TankGameWindow {
    public TankGameWindow() {
        JFrame app = new JFrame();
        app.setTitle("Tank Game");
        app.setSize(600, 600);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null); // Center the window
        app.add(new GamePanel()); // Add the game panel
        app.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        SwingUtilities.invokeLater(() -> {
            new TankGameWindow(); // Create and display the Tank Game window
        });
        
    }

}