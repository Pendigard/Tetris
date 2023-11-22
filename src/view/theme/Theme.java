package view.theme;

import controller.widget.GridWidget;
import model.block.Block;
import model.grid.Grid;
import model.piece.Piece;

import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public abstract class Theme {

    protected int width = 0;
    protected int height = 0;
    protected Clip backgroundMusic;

    public void setThemeSize(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public abstract void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid, Piece currentPiece);

    public abstract Color getColor(Block block);

    public abstract void drawBlock(Graphics graphics, GridWidget gridWidget, Block block, int x, int y, int opacity);

    public abstract void drawPiece(Graphics graphics, GridWidget gridWidget, Piece piece, int opacity);

    public abstract void drawBackground(Graphics graphics);

    public abstract void playBackgroundMusic();

    public abstract void stopBackgroundMusic();


}
