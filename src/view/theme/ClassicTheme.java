package view.theme;

import controller.widget.GridWidget;
import model.block.Block;
import model.grid.Grid;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ClassicTheme extends Theme {

    public ClassicTheme(String name) {
        super(name);
    }

    public Color getColor(Block block) {
        return switch (block.getType()) {
            case ORANGE -> Color.ORANGE;
            case BLUE -> Color.BLUE;
            case GREEN -> Color.GREEN;
            case YELLOW -> Color.YELLOW;
            case PURPLE -> Color.MAGENTA;
            case RED -> Color.RED;
            case CYAN -> Color.CYAN;
            default -> Color.BLACK;
        };
    }

    @Override
    public void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid) {
        int x = gridWidget.getPropX();
        int y = gridWidget.getPropY();
        for (int i = 0; i < grid.getNbRows(); i++) {
            for (int j = 0; j < grid.getNbColumns(); j++) {
                Block block = grid.getBlock(i, j);
                graphics.setColor(getColor(block));
                graphics.fillRect(x + j * gridWidget.getPropSize(), y + i * gridWidget.getPropSize(), gridWidget.getPropSize(), gridWidget.getPropSize());
            }
        }
    }
}
