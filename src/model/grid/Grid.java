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

    public boolean CanGoDown(Piece p){
        Block[][][] piece;
        piece = p.getBlock;
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {
                for (int k = 0; k < piece[i][j].length; k++) {

                    if(piece[i][j][k].getType() != BlockType.EMPTY &&
                            grd[p.getX()+j][p.getY()+k].getType() != BlockType.EMPTY){
                        return false;
                    }

                }
            }
        }
    }

    public boolean CanGoLeft(){

    }

    public boolean CanGoRight(){

    }
}
