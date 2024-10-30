package proj2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener {
    private PlayerTank playerTank;
    private EnemyTank enemyTank;
    private ArrayList<WallPiece> walls;
    private Timer timer;

    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            enemyTank.move();
            repaint();
        }
    }

    public GamePanel() {
        playerTank = new PlayerTank(100, 100, 100, 5, "DOWN");
        enemyTank =(new EnemyTank(200, 200, 100, 2, "UP"));
        walls = new ArrayList<>();
        
        // Sample enemy tank for demo
        
        
        // Sample walls for demo
        walls.add(new BrickWall(150, 150,true,50, Color.RED));
        walls.add(new SteelWall(300, 300, false, Color.GRAY));

        timer = new Timer(1000, new TimerListener());
        timer.start();

        setFocusable(true);
        addKeyListener(this);
    }


    private void moveEnemyTank(EnemyTank tank) {
        Random random = new Random();
        
        tank.move();
        preventWallCollision(tank);
    }

    private void preventWallCollision(BaseTank tank) {
        int originalX = tank.getX();
    int originalY = tank.getY();

    // Move the tank as usual
    tank.move();

    // Check for collision with each wall
    for (WallPiece wall : walls) {
        if (tank.getX() < wall.getX() + 20 && tank.getX() + 20 > wall.getX() &&
            tank.getY() < wall.getY() + 20 && tank.getY() + 20 > wall.getY()) {
            // Collision detected; revert to original position
            tank.x = originalX;
            tank.y = originalY;
            break;
        }
    }
}
    

    private void detectCollisions() {
        // Player-tank collision with walls
        preventWallCollision(playerTank);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw enemy tank with current location
        g.setColor(Color.RED);
        g.fillRect(enemyTank.getX(),enemyTank.getY(),50,50);

        //Draw player tank with current location
        g.setColor(Color.GREEN);
        g.fillRect(playerTank.getX(),playerTank.getY(),50,50);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> playerTank.setHeading("UP");
            case KeyEvent.VK_A -> playerTank.setHeading("LEFT");
            case KeyEvent.VK_S -> playerTank.setHeading("DOWN");
            case KeyEvent.VK_D -> playerTank.setHeading("RIGHT");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { /* Optional */ }
    @Override
    public void keyTyped(KeyEvent e) { /* Optional */ }
}
