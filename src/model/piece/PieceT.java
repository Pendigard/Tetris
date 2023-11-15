package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceT extends Piece {

    public PieceT() {
        super();
    }

    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.PURPLE), new Block(BlockType.PURPLE), new Block(BlockType.PURPLE)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.PURPLE), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.PURPLE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.PURPLE), new Block(BlockType.PURPLE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.PURPLE), new Block(BlockType.EMPTY)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.EMPTY), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.PURPLE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.PURPLE), new Block(BlockType.PURPLE), new Block(BlockType.PURPLE)}
                },
                {
                        {new Block(BlockType.EMPTY), new Block(BlockType.PURPLE), new Block(BlockType.EMPTY)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.PURPLE), new Block(BlockType.PURPLE)},
                        {new Block(BlockType.EMPTY), new Block(BlockType.PURPLE), new Block(BlockType.EMPTY)}
                }
        };
    }
}
