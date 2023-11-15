package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceZ extends Piece {

    public PieceZ() {
        super();
    }

    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.RED), new Block(BlockType.RED), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.RED), new Block(BlockType.RED)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.RED), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.RED), new Block(BlockType.RED), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.RED), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.RED), new Block(BlockType.RED), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.RED), new Block(BlockType.RED)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.RED)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.RED), new Block(BlockType.RED)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.RED), new Block(BlockType.EMPTY)}
                }
        };
    }
}
