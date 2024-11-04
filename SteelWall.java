package proj2;

import java.awt.*;

public class SteelWall extends WallPiece {
    protected Color color;

    public SteelWall(int x,int y, boolean destructible, Color color){
        super(x,y, destructible,40,40);
        this.color = color;
    }

    public Color getColor() {return color;}
    public void setColor(Color color) {this.color = color;}

}