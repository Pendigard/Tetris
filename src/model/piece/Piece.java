package model.piece;

import model.block.Block;
import model.block.BlockType;

public abstract class Piece implements Cloneable {
    public Block[][][] blocks; // rotation, x, y
    private int rotation; // The current rotation
    private int x;
    private int y;

    public Piece() {
        initBlocks();
        resetPosition();
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

    public Block[][] getPieceBoundingBox() { // Returns the smallest rectangle containing the piece
        int xMin = blocks[rotation].length - 1;
        int xMax = 0;
        int yMin = blocks[rotation][0].length -1;
        int yMax = 0;
        for (int i = 0; i < blocks[rotation].length; i++) {
            for (int j = 0; j < blocks[rotation][i].length; j++) {
                if (blocks[rotation][i][j].getType() != BlockType.EMPTY) {
                    if (i < xMin) {
                        xMin = i;
                    }
                    if (i > xMax) {
                        xMax = i;
                    }
                    if (j < yMin) {
                        yMin = j;
                    }
                    if (j > yMax) {
                        yMax = j;
                    }
                }
            }
        }
        Block[][] pieceBoundingBox = new Block[xMax-xMin+1][yMax-yMin+1];
        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                pieceBoundingBox[i-xMin][j-yMin] = blocks[rotation][i][j];
            }
        }
        return pieceBoundingBox;
    }

    public void print() {
        for (Block[] block : blocks[rotation]) {
            for (Block b : block) {
                System.out.print(b.getType().toString().charAt(0));
            }
            System.out.println();
        }
    }

    public void resetPosition() {
        int len = blocks[rotation].length;
        x = (10 - len) / 2;
        y = 0;
        int rotation = 0;
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
