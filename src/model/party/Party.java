package model.party;

import model.block.Block;
import model.grid.Grid;
import model.piece.*;

public class Party {

    private int score;
    private int highScore;
    private int level;
    private int lines;
    private int combo = 0;
    private int timeLastDrop = 0;
    private int timeLastLine = 0;
    private int timePlaced = -1;
    private Piece[] nextPieces = new Piece[5];
    private Grid grid = new Grid(20, 10);

    private int time = 0;

    private Piece holdPiece = null;

    boolean holdUsed = false;

    public Party() {
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
        int rotation = grid.getRotation(nextPieces[0]);
        nextPieces[0].setRotation(rotation);
    }

    public void hardDrop() {
        int nbDrop = 0;
        while (grid.CanGoDown(nextPieces[0])) {
            nextPieces[0].moveDown();
            nbDrop++;
        }
        addScore(nbDrop * 2);
        putPiece();
    }

    public void holdPiece() {
        if (holdPiece == null) {
            holdPiece = nextPieces[0];
            updateNextPieces();
            holdUsed = true;
        } else {
            if (holdUsed) return;
            Piece tmp = holdPiece;
            holdPiece = nextPieces[0];
            nextPieces[0] = tmp;
            holdUsed = true;
        }
        holdPiece.resetPosition();
    }

    public int getTimeInterval() {
        return 1000 - (level - 1) * 100;
    }

    public Piece getGhostPiece() {
        Piece ghostPiece = nextPieces[0].clone();
        while (grid.CanGoDown(ghostPiece)) {
            ghostPiece.moveDown();
        }
        return ghostPiece;
    }

    public Piece getHeldPiece() {
        return holdPiece;
    }

    public int convertLineToScore(int lines) {
        return switch (lines) {
            case 1 -> 100 * level;
            case 2 -> 300 * level;
            case 3 -> 500 * level;
            case 4 -> 800 * level;
            default -> 0;
        };
    }

    public void updateScoreLine(int linesFulled) {
        lines += linesFulled;
        score += convertLineToScore(linesFulled);
        if (this.time - timeLastLine <= 5000) {
            combo++;
            score += combo * 50 * level;
        } else {
            combo = 1;
        }
        timeLastLine = time;
    }

    private void updateLevel() {
        level = lines/10;
    }


    public void update(int time) {
        this.time = time;
        updateLevel();
        if (!grid.isValidPosition(getCurrentPiece())) {
            reset();
        }
        if (time - timeLastDrop >= getTimeInterval()) {
            timeLastDrop = time;
            moveDown();
        }
        if (timePlaced > 0 && !grid.CanGoDown(getCurrentPiece())) {
            if (time - timePlaced >= 500) {
                timePlaced = -1;
                putPiece();
            }
        }
        else if (!grid.CanGoDown(getCurrentPiece())) {
            timePlaced = time;
        }
        else {
            timePlaced = -1;
        }
    }

    public void putPiece(){
        holdUsed = false;
        int linesFulled = grid.putPiece(getCurrentPiece());
        if (linesFulled > 0) {
            updateScoreLine(linesFulled);
        }
        updateNextPieces();
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
