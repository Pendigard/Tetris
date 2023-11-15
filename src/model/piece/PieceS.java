package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceS extends Piece {

    public PieceS() {
        super();
    }

    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.GREEN), new Block(BlockType.GREEN)},
                        {new Block(BlockType.GREEN), new Block(BlockType.GREEN), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.GREEN), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.GREEN), new Block(BlockType.GREEN), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.GREEN), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.GREEN), new Block(BlockType.GREEN)},
                        {new Block(BlockType.GREEN), new Block(BlockType.GREEN), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.GREEN), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.GREEN), new Block(BlockType.GREEN), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.GREEN), new Block(BlockType.EMPTY)}
                }
        };
    }
}
