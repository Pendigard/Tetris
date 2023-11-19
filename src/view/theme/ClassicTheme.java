package view.theme;

import controller.widget.GridWidget;
import model.block.Block;
import model.block.BlockType;
import model.grid.Grid;
import model.piece.Piece;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ClassicTheme extends Theme {

    public ClassicTheme(String name) {
        super(name);
    }

    @Override
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
    public void drawBlock(Graphics graphics, GridWidget gridWidget, Block block, int x, int y) {
        graphics.setColor(getColor(block));
        graphics.fillRect(gridWidget.getPropX() + x * gridWidget.getPropSize(), gridWidget.getPropY() + y * gridWidget.getPropSize(), gridWidget.getPropSize(), gridWidget.getPropSize());
        graphics.setColor(Color.BLACK);
        graphics.drawRect(gridWidget.getPropX() + x * gridWidget.getPropSize(), gridWidget.getPropY() + y * gridWidget.getPropSize(), gridWidget.getPropSize(), gridWidget.getPropSize());

    }

    @Override
    public void drawCurrentPiece(Graphics graphics, GridWidget gridWidget, Piece piece) {
        Block[][] blocks = piece.getBlocks();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] != null) {
                    drawBlock(graphics, gridWidget, blocks[i][j], piece.getX() + j, piece.getY() + i);
                }
            }
        }

    }

    @Override
    public void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid, Piece currentPiece) {
        int x = gridWidget.getPropX();
        int y = gridWidget.getPropY();
        for (int i = 0; i < grid.getNbRows(); i++) {
            for (int j = 0; j < grid.getNbColumns(); j++) {
                Block block = grid.getBlock(i, j);
                drawBlock(graphics, gridWidget, block, j, i);
            }
        }
        drawCurrentPiece(graphics, gridWidget, currentPiece);
    }
}
