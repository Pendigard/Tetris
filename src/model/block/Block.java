package model.block;

public class Block {

    private BlockType type; // Type of the block (can be EMPTY)

    public Block(BlockType type) {
        this.type = type;
    }

    public Block() {
        this.type = BlockType.EMPTY;
    }

    public BlockType getType() {
        return type;
    }
}


