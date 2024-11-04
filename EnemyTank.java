package proj2;

import java.util.Random;

public class EnemyTank extends BaseTank{
    @SuppressWarnings("unused")
    private Random rand = new Random();

    public EnemyTank(int x, int y, int health, int speed, String heading){
        super(x, y, health, speed, heading);
    }

    @Override
    public void move() {
        Random rand = new Random();
        int direction = rand.nextInt(4);

        switch(direction) {
            case 0: setHeading("UP");y -= speed; break;
            case 1: setHeading("DOWN");y+= speed;break;
            case 2: setHeading("LEFT"); x-= speed;break;
            case 3: setHeading("RIGHT");x+= speed;break;
        }
    }
}