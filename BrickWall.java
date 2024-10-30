package proj2;

import java.awt.*;

public class BrickWall extends WallPiece{
    protected Color color;
    protected int health;

    public BrickWall(int x,int y, boolean destructible, int health,Color color){
        super(x,y,destructible);
        this.health = health;
        this.color = color;
    }

    public int getHealth() {return health;}
    public Color getColor() {return color;}
    public void setColor(Color color) {this.color = color;}
    
}
