package model.piece;

import model.block.Block;

public abstract class Piece {
    public Block[][][] blocks; // rotation, x, y
    private int rotation; // The current rotation
    private int x;
    private int y;

    public Piece() {
        x = 0;
        y = 5;
        rotation = 0;
        initBlocks();
    }

    abstract public void initBlocks();
    public void rotate() {
        rotation = (rotation + 1) % blocks.length;
    }

    public void moveLeft() {
        x--;
    }
    public void moveRight() {
        x++;
    }
    public void moveDown() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Block[][] getBlocks() {
        return blocks[rotation];
    }
}
