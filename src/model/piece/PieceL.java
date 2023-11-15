package model.piece;

import model.block.Block;
import model.block.BlockType;

public class PieceL extends Piece{

    public PieceL() {
        super();
        initBlocks();
    }
    @Override
    public void initBlocks() {
        blocks = new Block[][][]{
                {
                    {new Block(), new Block(), new Block(BlockType.ORANGE)},
                    {new Block(BlockType.ORANGE), new Block(BlockType.ORANGE), new Block(BlockType.ORANGE)},
                    {new Block(), new Block(), new Block()},
                },
                {
                        {new Block(BlockType.ORANGE), new Block(), new Block()},
                        {new Block(BlockType.ORANGE), new Block(), new Block()},
                        {new Block(BlockType.ORANGE), new Block(BlockType.ORANGE), new Block()},
                },
                {
                        {new Block(), new Block(), new Block()},
                        {new Block(BlockType.ORANGE), new Block(BlockType.ORANGE), new Block(BlockType.ORANGE)},
                        {new Block(BlockType.ORANGE), new Block(), new Block()},
                },
                {
                        {new Block(BlockType.ORANGE), new Block(BlockType.ORANGE), new Block()},
                        {new Block(), new Block(BlockType.ORANGE), new Block()},
                        {new Block(), new Block(BlockType.ORANGE), new Block()},
                },
        };
    }
}
