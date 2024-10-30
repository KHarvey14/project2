package Project2Demoa;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TankGamePanel extends JPanel {
    private PlayerTank playerTank;
    private EnemyTank enemyTank;
    private Timer timer;

    // Inner class for handling timer events
    private class TimerListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e) {
            enemyTank.move();
            repaint();
        }
    }

    // Inner class for handling key events
    private class TankKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_W: playerTank.move("UP"); break;
                case KeyEvent.VK_S: playerTank.move("DOWN"); break;
                case KeyEvent.VK_D: playerTank.move("RIGHT"); break;
                case KeyEvent.VK_A: playerTank.move("LEFT"); break;
            }
            repaint(); // Redraw the panel after movement
        }

        @Override
        public void keyReleased(KeyEvent e) {}
        @Override
        public void keyTyped(KeyEvent e) {}
    }

    @Override 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw enemy tank
        g.setColor(Color.RED);
        g.fillRect(enemyTank.getX(), enemyTank.getY(), 50, 50);
        g.fillRect(enemyTank.getX(), enemyTank.getY(), 40, 50);
        g.fillRect(enemyTank.getX(), enemyTank.getY(), 25, 25);

        // Draw player tank
        g.setColor(Color.ORANGE);
        g.fillRect(playerTank.getX(), playerTank.getY(), 50, 50);
    }

    // Constructor
    public TankGamePanel() {
        enemyTank = new EnemyTank(211, 543, 100, 20, "UP");
        playerTank = new PlayerTank(211, 543, 100, 20, "UP");

        // Set timer
        timer = new Timer(1000, new TimerListener());
        timer.start();

        // Configure the key listener
        setFocusable(true);
        addKeyListener(new TankKeyListener());
        requestFocusInWindow();
    }
}
