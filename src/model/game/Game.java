package model.game;

public class Game {

    private int score;
    private int level;
    private int lines;

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

    public void reset() {
        score = 0;
        level = 1;
        lines = 0;
    }
}
