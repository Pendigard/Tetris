package view.theme;

import controller.widget.GridWidget;
import controller.widget.HeldPieceWidget;
import model.block.Block;
import model.block.BlockType;
import model.grid.Grid;
import model.piece.Piece;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class ClassicTheme extends Theme {

    private static final Color BACKGROUND_COLOR = new Color(187, 187, 187, 255);

    private static final Color GRID_COLOR = new Color(5, 2, 49, 255);

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
            default -> GRID_COLOR;
        };
    }

    @Override
    public void drawBlock(Graphics graphics, Block block, int borderSize, int x, int y, int opacity) {
        Color color = getColor(block);
        int blockSize = borderSize - borderSize/10;
        graphics.setColor(GRID_COLOR);
        graphics.fillRect(x, y, borderSize, borderSize);
        graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity));
        graphics.fillRect( x+borderSize/20, y+borderSize/20, blockSize, blockSize);
    }


    @Override
    public void drawBackground(Graphics graphics){
        graphics.setColor(BACKGROUND_COLOR);
        graphics.fillRect( 0, 0, width , height);

    }

    @Override
    public void drawBox(Graphics graphics, int x, int y, int width, int height, int opacity) {
        graphics.setColor(GRID_COLOR);
        graphics.fillRoundRect(x, y, width, height, 10, 10);
    }

    public void drawText(Graphics graphics, int x,int y,int size){

    }

    @Override
    public void playBackgroundMusic() {
        try {
            File audioFile = new File("ressources/wav/Tetris_base.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);

            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);

            backgroundMusic.start();

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }

}
