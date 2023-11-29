package view.theme;

import controller.widget.GridWidget;
import controller.widget.HeldPieceWidget;
import model.block.Block;
import model.block.BlockType;
import model.grid.Grid;
import model.piece.Piece;

import java.awt.*;

public class SynthwaveTheme extends Theme{

    private static final Color GRID_COLOR = new Color(5, 2, 49, 255);
    @Override
    public Color getColor(Block block) {
        return switch (block.getType()) {
            case ORANGE -> new Color(255, 121, 0);
            case BLUE -> Color.BLUE;
            case GREEN -> new Color(157, 55, 231);
            case YELLOW -> new Color(255, 213, 0);
            case PURPLE -> new Color(98, 21, 190);
            case RED -> new Color(199, 20, 20);
            case CYAN -> Color.CYAN;
            default -> GRID_COLOR;
        };
    }

    @Override
    public void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid, Piece currentPiece) {
        int x = gridWidget.getRealX(width);
        int y = gridWidget.getRealY(height);
        int blockSize = gridWidget.getRealHeight(height)/gridWidget.getParty().getGrid().getNbRows();
        for (int i = 0; i < grid.getNbRows(); i++) {
            for (int j = 0; j < grid.getNbColumns(); j++) {
                Block block = grid.getBlock(i, j);
                drawBlock(graphics, block, blockSize, x+j*blockSize, y+i*blockSize, 255);
            }
        }
        drawGhostPiece(graphics, gridWidget, 200);
        drawPiece(graphics, blockSize, x + currentPiece.getX() * blockSize, y + currentPiece.getY() * blockSize, currentPiece, 255);
    }


    @Override
    public void drawBlock(Graphics graphics, Block block, int borderSize, int x, int y, int opacity) {
        Color color = getColor(block);
        int blockSize = borderSize - 8;
        graphics.setColor(new Color(GRID_COLOR.getRed(), GRID_COLOR.getGreen(), GRID_COLOR.getBlue(), 220));
        graphics.fillRect(x, y, borderSize, borderSize);
        if (block.getType() != BlockType.EMPTY) {
            for (int i = 0; i < 4; i++) {
                graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity-100 - i * 20));
                graphics.drawRect(x + i, y + i, borderSize - i * 2, borderSize - i * 2);
            }
            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity-100-60));
            ;
            graphics.fillRect(x + 4, y + 4, blockSize, blockSize);
        }
    }


    public void drawText(Graphics graphics, int x,int y,String txt){
        Font font = new Font("Arial", Font.BOLD, 20);
        graphics.setFont(font);
        graphics.setColor(Color.BLUE);
        graphics.drawString(txt, x, y);
    }

    @Override
    public void drawBox(Graphics graphics, int x, int y, int width, int height, int opacity) {
        graphics.setColor(new Color(GRID_COLOR.getRed(), GRID_COLOR.getGreen(), GRID_COLOR.getBlue(), 220));
        graphics.fillRoundRect(x, y, width, height, 10, 10);
    }

    public void drawText(Graphics graphics, int x,int y,int size){

    }

    @Override
    public void drawBackground(Graphics graphics) {
        Image background = Toolkit.getDefaultToolkit().getImage("resources/images/background/synthwave.jpg");
        graphics.drawImage(background, 0, 0, width, height, null);
    }

    @Override
    public void playBackgroundMusic() {

    }

    @Override
    public void stopBackgroundMusic() {

    }
}
