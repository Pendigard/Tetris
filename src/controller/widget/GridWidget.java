package controller.widget;

import model.game.Game;
import model.grid.Grid;
import view.theme.Theme;

import java.awt.*;

public class GridWidget extends Widget {

    public GridWidget(int x, int y, int size) {
        super(x, y, size);
    }

    @Override
    public void paint(Graphics g, Theme theme, Game game) {
        theme.drawGrid(g, this, game.getGrid(), game.getCurrentPiece());
    }
}
