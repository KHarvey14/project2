package proj_2;

import java.util.Math;

public class MapLayout {
    public static void main(String[] args) {
        int mapX = 10;
        int mapY = 10;
        WallPiece[][] mapDesign = new WallPiece[mapX][mapY];

    for (int i = 0; i <= mapX; i++) {
        for (int j = 0; j <= mapY; j++) {
            if (i == 0 || i == mapX || j == 0 || j == mapY) {
                mapDesign[i][j] = WallPiece.SteelWall; 
            }
            else if (i == 9 && j == 8) {
                mapDesign[i][j] = WallPiece.BrickWall;
            }
        }
    }

    for (int i = Math.abs(mapX/4))

}
}

