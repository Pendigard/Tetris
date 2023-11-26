package view.theme;

import controller.widget.GridWidget;
import controller.widget.HeldPieceWidget;
import controller.widget.HeldPieceWidget;
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

    public abstract void drawHeldPiece(Graphics graphics, HeldPieceWidget gridWidget, Piece piece, int opacity);

    public void drawGridBorder(Graphics graphics, GridWidget gridWidget, int propSize, Color color) {
        int borderHeight = (int)((gridWidget.getPropHeight()+propSize)/100.0 * height);
        int borderWidth = (int)(borderHeight/gridWidget.getParty().getGrid().getNbRows() * gridWidget.getParty().getGrid().getNbColumns() + (propSize/2.0)/100.0 * width);
        int borderX = (int)((gridWidget.getPropX()-propSize/2)/100.0 * width);
        int borderY = (int)((gridWidget.getPropY()-propSize/2)/100.0 * height);
        graphics.setColor(color);
        graphics.fillRoundRect(borderX, borderY, borderWidth, borderHeight, 10, 10);
    }

    public abstract void playBackgroundMusic();

    public abstract void stopBackgroundMusic();


}
