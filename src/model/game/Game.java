package model.game;

import model.grid.Grid;
import model.piece.*;

public class Game {

    private int score;
    private int highScore;
    private int level;
    private int lines;
    Piece[] nextPieces = new Piece[5];

    Grid grid = new Grid(20, 10);

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

    public Piece getRandPiece() {
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
}
