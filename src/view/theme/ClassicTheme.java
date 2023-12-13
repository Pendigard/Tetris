package view.theme;

import controller.widget.GridWidget;
import controller.widget.HeldPieceWidget;
import model.block.Block;
import model.block.BlockType;
import model.grid.Grid;
import model.piece.Piece;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class ClassicTheme extends Theme {

    private static final Color BACKGROUND_COLOR = new Color(187, 187, 187, 255);

    private Image background;

    private static final Color GRID_COLOR = new Color(5, 2, 49, 255);

    public ClassicTheme(){
        super("Classic");
        loadTheme();
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
    public void drawBox(Graphics graphics, int x, int y, int width, int height, int opacity) {
        graphics.setColor(GRID_COLOR);
        graphics.fillRoundRect(x, y, width, height, 10, 10);
    }

    public void drawText(Graphics graphics, int x,int y,String txt){
        Font font = new Font("Arial", Font.BOLD, 20);
        graphics.setFont(font);
        graphics.setColor(Color.BLUE);
        graphics.drawString(txt, x, y);
    }

    @Override
    public void drawBackground(Graphics graphics) {
        int imgHeight = height;
        int imgWidth = (int)(((double) background.getWidth(null) / background.getHeight(null)) * imgHeight);
        graphics.drawImage(background, 0, 0, imgWidth, imgHeight, null);
    }

    @Override
    public void loadTheme(){
        fontName = "arial";
        background = Toolkit.getDefaultToolkit().getImage("resources/images/background/classic_background.png");
    }

    @Override
    public void playBackgroundMusic() {
        try {
            File audioFile = new File("resources/wav/Tetris_base.wav");
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
