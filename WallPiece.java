package proj2;

public abstract class WallPiece {
    protected boolean destructible;
    protected int x, y;
    protected int width, height;


    // Constructer
    public WallPiece(int x, int y, boolean destructible, int width, int height){
        this.x = x;
        this.y = y;
        this.destructible = destructible; 
        this.width = width; 
        this.height = height; 
    }

    // Getters and Setters
    public boolean getIsDestrutible() {return destructible;}

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    public int getY() {return y;}
    public void setY(int y) {this.y = y;}

    public int getWidth() { return width; } 
    public int getHeight() { return height; }

}