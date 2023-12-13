package view.theme;

import controller.widget.ButtonWidget;
import controller.widget.GridWidget;
import model.block.Block;
import model.block.BlockType;
import model.grid.Grid;
import model.piece.Piece;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RetroTheme extends Theme{

    Image background;
    Image[] Iblock;

    public RetroTheme(){
        super();
        loadTheme();
    }

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
    public void drawBlock(Graphics graphics, Block block, int borderSize, int x, int y, int opacity)  {
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity/255);
        ((Graphics2D) graphics).setComposite(ac);
        switch (block.getType()) {
            case YELLOW :
                graphics.drawImage(Iblock[5], x, y, borderSize, borderSize, null);
                break;
            case RED :
                graphics.drawImage(Iblock[4], x, y, borderSize, borderSize, null);
                break;
            case CYAN :
                graphics.drawImage(Iblock[3], x, y, borderSize, borderSize, null);
                break;
            case GREEN :
                graphics.drawImage(Iblock[2], x, y, borderSize, borderSize, null);
                break;
            case BLUE :
                graphics.drawImage(Iblock[1], x, y, borderSize, borderSize, null);
                break;
            case ORANGE :
                graphics.drawImage(Iblock[0], x, y, borderSize, borderSize, null);
                break;
            case PURPLE :
                graphics.drawImage(Iblock[6], x, y, borderSize, borderSize, null);
                break;
            default :
                graphics.drawImage(Iblock[7], x, y, borderSize, borderSize, null);
                break;
        }

    }

    @Override
    public void drawBox(Graphics graphics, int x, int y, int width, int height, int opacity) {
        graphics.drawImage(Iblock[7], x, y, width, height, null);
    }
    @Override
    public void drawBackground(Graphics graphics) {
        graphics.drawImage(background, 0, 0, width, height, null);
    }

    public void drawButton(Graphics graphics, ButtonWidget buttonWidget) {
        int x = buttonWidget.getRealX(width);
        int y = buttonWidget.getRealY(height);
        int widgetWidth = buttonWidget.getRealWidth(width);
        int widgetHeight = buttonWidget.getRealHeight(height);
        graphics.drawImage(Iblock[7], x, y, widgetWidth, widgetHeight, null);
        String text = buttonWidget.getText();
        if (buttonWidget.selected) {
            text = "> " + text + " <";
        }
        drawTextCentered(graphics, x, y, widgetWidth, widgetHeight, Color.WHITE, widgetHeight/2, text);
    }

    @Override
    public void loadTheme(){
        fontName = "VCR OSD Mono";
        background = Toolkit.getDefaultToolkit().getImage("resources/images/Retro/RetroFond.png");

        Iblock = new Image[8];
        for (int i = 0; i < 8; i++) {
            Iblock[i] = Toolkit.getDefaultToolkit().getImage("resources/images/Retro/cube" + (i + 1) + ".png");
        }
    }

    @Override
    public void playBackgroundMusic() {
        try {
            File audioFile = new File("resources/wav/Tetris_Retro.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);

            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);

            backgroundMusic.start();

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
