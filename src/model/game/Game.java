package model.game;

import model.block.Block;
import model.grid.Grid;
import model.piece.*;

public class Game {

    private int score;
    private int highScore;
    private int level;
    private int lines;
    private Piece[] nextPieces = new Piece[5];

    private Grid grid = new Grid(20, 10);

    public Game() {
        reset();
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void addLines(int lines) {
        this.lines += lines;
    }

    public void addLevel(int level) {
        this.level += level;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public int getLines() {
        return lines;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void loadHighScore() {
        // Load the highscore from a file
        // TODO

    }

    public void reset() {
        score = 0;
        level = 1;
        lines = 0;
        initNextPieces();
        grid.reset();
    }

    private Piece getRandPiece() {
        int rand = (int) (Math.random() * 7);
        return switch (rand) {
            case 1 -> new PieceJ();
            case 2 -> new PieceO();
            case 3 -> new PieceS();
            case 4 -> new PieceZ();
            case 5 -> new PieceT();
            case 6 -> new PieceI();
            default -> new PieceL();
        };
    }

    public Piece getCurrentPiece() {
        return nextPieces[0];
    }

    public void initNextPieces() {
        for (int i = 0; i < nextPieces.length; i++) {
            nextPieces[i] = getRandPiece();
        }
    }

    public void updateNextPieces() {
        for (int i = 0; i < nextPieces.length - 1; i++) {
            nextPieces[i] = nextPieces[i + 1];
        }
        nextPieces[nextPieces.length - 1] = getRandPiece();
    }

    public Piece[] getNextPieces() {
        return nextPieces;
    }

    public Grid getGrid() {
        return grid;
    }

    public void moveDown() {
        if (grid.CanGoDown(nextPieces[0]))
            nextPieces[0].moveDown();
    }

    public void moveLeft() {
        if (grid.CanGoLeft(nextPieces[0]))
            nextPieces[0].moveLeft();
    }

    public void moveRight() {
        if (grid.CanGoRight(nextPieces[0]))
            nextPieces[0].moveRight();
    }

    public void rotate() {
        nextPieces[0].rotate();
    }

    public void hardDrop() {
        while (grid.CanGoDown(nextPieces[0])) {
            System.out.println("Can go down");
            nextPieces[0].moveDown();
        }
    }

    public void print() {
        Block[][] g = grid.getGrid();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++)
                if (getCurrentPiece().getY() <= i && i < getCurrentPiece().getY() + getCurrentPiece().getBlocks().length &&
                        getCurrentPiece().getX() <= j && j < getCurrentPiece().getX() + getCurrentPiece().getBlocks()[0].length)
                    System.out.print(getCurrentPiece().getBlocks()[i - getCurrentPiece().getY()][j - getCurrentPiece().getX()].getType().toString().charAt(0));
                else
                    System.out.print(g[i][j].getType().toString().charAt(0));
            System.out.println();
        }
    }
}
