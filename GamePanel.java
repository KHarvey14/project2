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
        setPreferredSize(new Dimension(600, 600)); // Set preferred size
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
        Color darkRed = new Color(139, 0, 0); // RGB for dark red
        Color darkGreen = new Color(0, 100, 0); // RGB for dark green

        g.setColor(Color.RED);
        g.fillRect(enemyTank.getX(),enemyTank.getY(),40,50); // Body
        g.setColor(darkRed); 
        g.fillRect(enemyTank.getX()-10,enemyTank.getY()-5,10,60); // Left wheels
        g.fillRect(enemyTank.getX()+40,enemyTank.getY()-5,10,60); // Right wheels
        g.fillRect(enemyTank.getX()+5,enemyTank.getY()+5,30,35); // Medium Box
        g.setColor(Color.RED);
        g.fillRect(enemyTank.getX()+11,enemyTank.getY()+10,18,20); // Small Box
        g.setColor(Color.BLACK);
        g.fillRect(enemyTank.getX()+17,enemyTank.getY()-20,5,20); // Big shooter
        g.fillRect(enemyTank.getX()+10,enemyTank.getY()-8,20,8); // Big shooter base
        g.fillRect(enemyTank.getX()+18,enemyTank.getY()+5,4,8); // Small shooter


        //Draw player tank with current location
        g.setColor(Color.GREEN);
        g.fillRect(playerTank.getX(),playerTank.getY(),50,50); // Body
        g.setColor(darkGreen);
        g.fillRect(playerTank.getX()-10,playerTank.getY()-5,10,60); // Left wheels
        g.fillRect(playerTank.getX()+40,playerTank.getY()-5,10,60); // Right wheels
        g.fillRect(playerTank.getX()+5,playerTank.getY()+5,30,35); // Medium Box
        g.setColor(Color.GREEN);
        g.fillRect(playerTank.getX()+11,playerTank.getY()+10,18,20); // Small Box
        g.setColor(Color.BLACK);
        g.fillRect(playerTank.getX()+17,playerTank.getY()-20,5,20); // Big shooter
        g.fillRect(playerTank.getX()+10,playerTank.getY()-8,20,8); // Big shooter base
        g.fillRect(playerTank.getX()+18,playerTank.getY()+5,4,8); // Small shooter
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> playerTank.setHeading("UP");
            case KeyEvent.VK_A -> playerTank.setHeading("LEFT");
            case KeyEvent.VK_S -> playerTank.setHeading("DOWN");
            case KeyEvent.VK_D -> playerTank.setHeading("RIGHT");
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { /* Optional */ }
    @Override
    public void keyTyped(KeyEvent e) { /* Optional */ }
}