package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceI extends Piece {

    public PieceI() {
        super();
    }

    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.CYAN), new Block(BlockType.CYAN), new Block(BlockType.CYAN), new Block(BlockType.CYAN)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.CYAN), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.CYAN), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.CYAN), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.CYAN), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.CYAN), new Block(BlockType.CYAN), new Block(BlockType.CYAN), new Block(BlockType.CYAN)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)}
                }
        };
    }
}
