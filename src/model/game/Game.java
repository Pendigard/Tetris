package model.game;

import model.piece.*;

public class Game {

    private int score;
    private int highScore;
    private int level;
    private int lines;
    Piece currentPiece;

    Piece[] nextPieces = new Piece[5];

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
    }

    public Piece getRandPiece() {
        int rand = (int) (Math.random() * 7);
        switch (rand) {
            case 0:
                return new PieceL();
                break;
            case 1:
                return new PieceJ();
                break;
            case 2:
                return new PieceO();
                break;
            case 3:
                return new PieceS();
                break;
            case 4:
                return new PieceZ();
                break;
            case 5:
                return new PieceT();
                break;
            case 6:
                return new PieceI();
                break;
            default:
                return new PieceL();
                break;
        }
    }
}
