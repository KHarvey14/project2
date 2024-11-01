package proj_2;

public class WallPiece {
    private String wallType;

    public WallPiece(String wallType) {
        this.wallType = wallType;
    }

    @Override
    public String toString() {
        return wallType;
    }
}
