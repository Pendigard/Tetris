package model.piece;

import model.block.Block;

public abstract class Piece implements Cloneable {
    public Block[][][] blocks; // rotation, x, y
    private int rotation; // The current rotation
    private int x;
    private int y;

    public Piece() {
        x = 5;
        y = 0;
        rotation = 0;
        initBlocks();
    }

    abstract public void initBlocks();
    public void rotate() {
        rotation = (rotation + 1) % blocks.length;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
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

    public void moveUp() {
        y--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRotation() {
        return rotation;
    }

    public Block[][] getBlocks() {
        return blocks[rotation];
    }

    public void print() {
        for (Block[] block : blocks[rotation]) {
            for (Block b : block) {
                System.out.print(b.getType().toString().charAt(0));
            }
            System.out.println();
        }
    }

    @Override
    public Piece clone() {
        try {
            Piece clone = (Piece) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
