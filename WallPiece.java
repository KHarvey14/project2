package proj2;

public abstract class WallPiece {
    protected boolean destructible;
    protected int x, y;

    public WallPiece(int x, int y, boolean destructible){
        this.x = x;
        this.y = y;
        this.destructible = destructible; 
    }

    public boolean getIsDestrutible() {return destructible;}

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    public int getY() {return y;}
    public void setY(int y) {this.y = y;}

}
