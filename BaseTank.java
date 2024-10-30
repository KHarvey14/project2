package proj2;

public abstract class BaseTank {
    protected int health;
    protected int x;
    protected int y;
    protected int speed;
    protected String heading;

    public BaseTank(){
        this.x = 0;
        this.y = 0;
        this.health = 1;
        this.speed = 1;
        this.heading = "UP";
    }

    public BaseTank(int x, int y, int health, int speed, String heading){
        this.x = x;
        this.y = y;
        this.health = health;
        this.speed = speed;
        this.heading = heading;
    }

    public int getX(){return x;}    
    public void setX(int x){this.x = x;}

    public int getY(){return y;}    
    public void setY(int y){this.y = y;}

    public int getHealth(){return health;}    
    public void setHealth(int health){this.health = health;}

    public int getSpeed(){return speed;}    
    public void setSpeed(int speed){this.speed = speed;}

    public String getHeading(){return heading;}    
    public void setHeading(String heading){this.heading = heading;}

    public abstract void move(); // it is mandatory to Override this function


}
