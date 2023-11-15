package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceO extends Piece {

    public PieceO() {
        super();
    }

    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                        {new Block(BlockType.YELLOW), new Block(BlockType.YELLOW)},
                        {new Block(BlockType.YELLOW), new Block(BlockType.YELLOW)}
                }
        };
    }
}
