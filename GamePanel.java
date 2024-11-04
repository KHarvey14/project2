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

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            enemyTank.move();
            preventWallCollision(enemyTank); // Check for collisions with walls for the enemy tank
            repaint();
        }
    }

    public GamePanel() {
        setPreferredSize(new Dimension(600, 600)); // size
        playerTank = new PlayerTank(300, 400, 100, 5, "UP");
        enemyTank =(new EnemyTank(200, 50, 100, 2, "DOWN"));
        walls = new ArrayList<>();
        
        
        // walls
        walls.add(new BrickWall(150, 150,true,50, Color.RED));
        walls.add(new BrickWall(100, 150,true,50, Color.RED));
        walls.add(new BrickWall(200, 150,true,50, Color.RED));
        walls.add(new SteelWall(300, 300, false, Color.GRAY));
        walls.add(new SteelWall(100, 300, false, Color.GRAY));

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
        if (tank.getX() < wall.getX() + wall.getWidth() &&
            tank.getX() + 60 > wall.getX() && 
            tank.getY() < wall.getY() + wall.getHeight() &&
            tank.getY() + 60 > wall.getY()) { 
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

        // Draw walls
        for (WallPiece wall : walls) {
            g.setColor(wall instanceof BrickWall ? ((BrickWall) wall).getColor() : ((SteelWall) wall).getColor());
            g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
        }

        // Draw enemy tank
        drawTank(g, enemyTank, Color.RED, new Color(139, 0, 0)); 

        // Draw player tank
        drawTank(g, playerTank, Color.GREEN, new Color(0, 100, 0)); 
        
    }

    private void drawTank(Graphics g, BaseTank tank, Color bodyColor, Color secondColor) {
        g.setColor(bodyColor);
        
        // Draw tank based on heading
        switch (tank.getHeading()) {
            case "UP":
                g.setColor(bodyColor);
                g.fillRect(tank.getX(), tank.getY(), 40, 50); // Body
    
                g.setColor(secondColor);
                g.fillRect(tank.getX() - 10, tank.getY() - 5, 10, 60); // Left wheels
                g.fillRect(tank.getX() + 40, tank.getY() - 5, 10, 60); // Right wheels
                g.fillRect(tank.getX()+5,tank.getY()+5,30,35); // Medium Box

                g.setColor(bodyColor);
                g.fillRect(tank.getX()+11,tank.getY()+10,18,20); // Small Box

                g.setColor(Color.BLACK);
                g.fillRect(tank.getX() + 18, tank.getY() + 5, 4, 15); // Shooter
                break;
            case "DOWN":
                g.setColor(bodyColor);
                g.fillRect(tank.getX(), tank.getY(), 40, 50); // Body

                g.setColor(secondColor);
                g.fillRect(tank.getX() - 10, tank.getY() - 5, 10, 60); // Left wheels
                g.fillRect(tank.getX() + 40, tank.getY() - 5, 10, 60); // Right wheels
                g.fillRect(tank.getX() + 5, tank.getY() + 10, 30, 35); // Medium Box
            
                g.setColor(bodyColor);
                g.fillRect(tank.getX() + 11, tank.getY() + 20, 18, 20); // Small Box
            
                g.setColor(Color.BLACK);
                g.fillRect(tank.getX() + 18, tank.getY() + 30, 4, 15); // Shooter facing down
                break;
            case "LEFT":
                g.setColor(bodyColor);
                g.fillRect(tank.getX(), tank.getY(), 50, 40); // Body

                g.setColor(secondColor);
                g.fillRect(tank.getX() - 5, tank.getY() - 10, 60, 10); // Left wheels
                g.fillRect(tank.getX() -5, tank.getY() +40, 60, 10); // Right wheels
                g.fillRect(tank.getX() + 5, tank.getY() + 5, 35, 30); // Medium Box
        
                g.setColor(bodyColor);
                g.fillRect(tank.getX() + 10, tank.getY() + 11, 20, 18); // Small Box
        
                g.setColor(Color.BLACK);
                g.fillRect(tank.getX() + 5, tank.getY() + 18, 15, 4); // Shooter facing down
                break;
            case "RIGHT":
                g.setColor(bodyColor);
                g.fillRect(tank.getX(), tank.getY(), 50, 40); // Body

                g.setColor(secondColor);
                g.fillRect(tank.getX() - 5, tank.getY() - 10, 60, 10); // Left wheels
                g.fillRect(tank.getX() - 5, tank.getY() + 40, 60, 10); // Right wheels
                g.fillRect(tank.getX() + 10, tank.getY() + 5, 35, 30); // Medium Box
            
                g.setColor(bodyColor);
                g.fillRect(tank.getX() + 20, tank.getY() + 11, 20, 18); // Small Box
            
                g.setColor(Color.BLACK);
                g.fillRect(tank.getX() + 30, tank.getY() + 18, 15, 4); // Shooter facing down
                break;
        }
    }
        

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> playerTank.setHeading("UP");
            case KeyEvent.VK_A -> playerTank.setHeading("LEFT");
            case KeyEvent.VK_S -> playerTank.setHeading("DOWN");
            case KeyEvent.VK_D -> playerTank.setHeading("RIGHT");
        }

        // Move player tank based on current heading
        playerTank.move();
        preventWallCollision(playerTank); // Check for collisions for player tank
        repaint();
    }
        


    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    
}