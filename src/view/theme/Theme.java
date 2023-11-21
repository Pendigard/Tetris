package view.theme;

import controller.widget.GridWidget;
import model.block.Block;
import model.grid.Grid;
import model.piece.Piece;

import java.awt.*;

public abstract class Theme {

    protected int width = 0;
    protected int height = 0;

    public void setThemeSize(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public abstract void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid, Piece currentPiece);

    public abstract Color getColor(Block block);

    public abstract void drawBlock(Graphics graphics, GridWidget gridWidget, Block block, int x, int y);

    public abstract void drawCurrentPiece(Graphics graphics, GridWidget gridWidget, Piece piece);
}
