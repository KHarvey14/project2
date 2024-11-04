package proj2;

public class PlayerTank extends BaseTank {
    public PlayerTank(int x, int y, int health, int speed, String heading){
        super(x,y,health,speed,heading);
    }

    @Override
    public void move() {
        switch(heading) {
            case "UP": y -= speed; break;
            case "DOWN": y+= speed;break;
            case "LEFT": x-= speed;break;
            case "RIGHT":x+= speed;break;
        }
    }
    
}
