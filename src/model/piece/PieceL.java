package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceL extends Piece{

    public PieceL() {
        super();
    }
    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.ORANGE), new Block(BlockType.ORANGE), new Block(BlockType.ORANGE)},
                        {new Block(BlockType.ORANGE), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.ORANGE), new Block(BlockType.ORANGE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.ORANGE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.ORANGE), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.ORANGE)},
                        {new Block(BlockType.ORANGE), new Block(BlockType.ORANGE), new Block(BlockType.ORANGE)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.ORANGE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.ORANGE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.ORANGE), new Block(BlockType.ORANGE)}
                }
        };
    }
}
