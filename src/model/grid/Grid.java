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

                if ( grd[0].length >= p.getY()+j+1 || (piece[i][j].getType() != BlockType.EMPTY &&
                        grd[p.getX() + i][p.getY() + j+1].getType() != BlockType.EMPTY) ){
                    return false;
                }

            }
        }
        return true;
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

    public int CanRotate(Piece p) {
        for(int k=0;k<4;k++) {
            p.rotate();
            Block[][] piece = p.getBlocks();

            for (int i = 0; i < piece.length; i++) {
                for (int j = 0; j < piece[i].length; j++) {

                    if (piece[i][j].getType() != BlockType.EMPTY &&
                            grd[p.getX() + i][p.getY() + j].getType() == BlockType.EMPTY) {
                        return p.getRotation();
                    }

                }
            }
        }
        return -1;
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
        int result=0;
        for(int i=grd[0].length;i>0;i--){
            boolean full = true;
            for(int j=0;j<grd.length;j++){
                if (grd[i][j].getType() == BlockType.EMPTY) {
                    full = false;
                    break;
                }
            }
            if(full) result++;
        }
        return result;
    }
}
