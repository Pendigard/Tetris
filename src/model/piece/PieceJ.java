package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceJ extends  Piece {

    public PieceJ() {
        super();
    }

    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.BLUE), new Block(BlockType.BLUE), new Block(BlockType.BLUE)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.BLUE)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.BLUE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.BLUE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.BLUE), new Block(BlockType.BLUE), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.BLUE), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.BLUE), new Block(BlockType.BLUE), new Block(BlockType.BLUE)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.BLUE), new Block(BlockType.BLUE)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.BLUE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.BLUE), new Block(BlockType.EMPTY)}
                }
        };
    }
}
