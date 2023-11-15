package model.grid;
import model.block.Block;
import model.block.BlockType;
import model.piece.Piece;

public class Grid {
    private int lenght;
    private int width;
    private  Block[][] grd;

    public Grid(int lenght, int width){
        this.lenght = lenght;
        this.width = width;
        grd = new Block[lenght][width];

        for(int i=0;i < lenght; i++){
            for(int j=0;j < width; j++){
                grd[i][j] = new Block();
            }
        }
    }

    public boolean CanGoDown(Piece p) {
        Block[][] piece = p.getBlocks();

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {

                if (piece[i][j].getType() != BlockType.EMPTY &&
                        grd[p.getX() + i][p.getY() + j+1].getType() != BlockType.EMPTY) {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean CanGoLeft(Piece p) {
        Block[][] piece = p.getBlocks();

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {

                if (piece[i][j].getType() != BlockType.EMPTY &&
                        grd[p.getX() + i-1][p.getY() + j].getType() != BlockType.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean CanGoRight(Piece p) {
        Block[][] piece = p.getBlocks();

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {

                if (piece[i][j].getType() != BlockType.EMPTY &&
                        grd[p.getX() + i+1][p.getY() + j].getType() != BlockType.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean CanRotate(Piece p) {
        Block[][] piece = p.getBlocks();

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {

                if (piece[i][j].getType() != BlockType.EMPTY &&
                        grd[p.getX() + i][p.getY() + j].getType() != BlockType.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
