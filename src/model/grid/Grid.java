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
        /*
        @brief : check if the piece is in a valid position
        @param p : piece to check
        @return : true if the piece is in a valid position, false otherwise
         */
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

    public int putPiece(Piece p) {
        /*
        @brief : put the block of the piece in the grid
        @param p : piece to put
        @return : number of line completed
         */
        Block[][] piece = p.getBlocks();

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {

                if (piece[i][j].getType() != BlockType.EMPTY){
                        grd[p.getY() + i][p.getX() + j].setType(piece[i][j].getType());
                }

            }
        }
        return checkLine();
    }

    public int checkLine(){
        int result=0;
        for(int i = 0; i < grd.length; i++){
            boolean full = true;
            for(int j=0;j<grd[0].length;j++){
                if (grd[i][j].getType() == BlockType.EMPTY) {
                    full = false;
                    break;
                }
            }
            if(full) {
                result++;
                removeLine(i);
            }
        }
        return result;
    }

    public void removeLine(int val){
        for(int i = val; i>0; i--) {
            for (int j = 0; j < grd[0].length; j++) {
                grd[i][j].setType(grd[i - 1][j].getType());
            }
        }
    }
}
