package model.grid;
import model.block.Block;
import model.block.BlockType;
import model.piece.Piece;

public class Grid {
    private Block[][] grd;

    public Grid(int length, int width){
        grd = new Block[length][width];

        for(int i=0;i < length; i++){
            for(int j=0;j < width; j++){
                grd[i][j] = new Block();
            }
        }
    }

    public Block[][] getGrid(){
        return grd;
    }

    public void reset() {
        for (Block[] blocks : grd) {
            for (Block block : blocks) {
                block.setType(BlockType.EMPTY);
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

    public void putPiece(Piece p) {
        Block[][] piece = p.getBlocks();

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {

                if (piece[i][j].getType() != BlockType.EMPTY){
                        grd[p.getX() + i][p.getY() + j].setType(piece[i][j].getType());

                }

            }
        }
    }

    public int checkLine(Piece p){
        return 3;
    }
}
