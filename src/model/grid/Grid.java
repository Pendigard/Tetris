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

    public int getNbRows() {
        return grd.length;
    }

    public int getNbColumns() {
        return grd[0].length;
    }

    public Block getBlock(int i, int j) {
        return grd[i][j];
    }

    public void reset() {
        for (Block[] blocks : grd) {
            for (Block block : blocks) {
                block.setType(BlockType.EMPTY);
            }
        }
    }

    public boolean CanGoDown(Piece p) {
        p.moveDown();
        boolean valid = isValidPosition(p);
        p.moveUp();
        return valid;
    }

    public boolean CanGoLeft(Piece p) {
        p.moveLeft();
        boolean valid = isValidPosition(p);
        p.moveRight();
        return valid;
    }

    public boolean CanGoRight(Piece p) {
        p.moveRight();
        boolean valid = isValidPosition(p);
        p.moveLeft();
        return valid;
    }

    public int getRotation(Piece p) {
        for(int k=0;k<4;k++) {
            p.rotate();
            if (isValidPosition(p)) {
                return p.getRotation();
            }
        }
        return -1;
    }

    public boolean isValidPosition(Piece p) {
        Block[][] piece = p.getBlocks();
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {
                if (piece[i][j].getType() != BlockType.EMPTY) {
                    if (p.getX() + j < 0 || p.getX() + j >= grd[0].length || p.getY() + i >= grd.length) {
                        return false;
                    } else if (grd[p.getY() + i][p.getX() + j].getType() != BlockType.EMPTY) {
                        return false;
                    }
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
                        grd[p.getY() + i][p.getX() + j].setType(piece[i][j].getType());
                }

            }
        }
    }

    public int checkLine(Piece p){
        int result=0;
        for(int i=grd.length;i>0;i--){
            boolean full = true;
            for(int j=0;j<grd[0].length;j++){
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
