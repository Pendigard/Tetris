package view.theme;

import controller.widget.GridWidget;
import model.block.Block;
import model.block.BlockType;
import model.grid.Grid;
import model.piece.Piece;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class ClassicTheme extends Theme {

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
    public void drawBlock(Graphics graphics, GridWidget gridWidget, Block block, int x, int y, int opacity) {
        Color color = getColor(block);
        graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity));
        double realX = gridWidget.getPropX()/100.0 * width;
        double realY = gridWidget.getPropY()/100.0 * height;
        double realCellSize = (gridWidget.getPropHeight()/100.0 * height)/gridWidget.getParty().getGrid().getNbRows();
        graphics.fillRect( (int)realX + x * (int)realCellSize, (int)realY + y * (int)realCellSize, (int)realCellSize, (int)realCellSize);
        graphics.setColor(Color.BLACK);
        graphics.drawRect((int)realX + x * (int)realCellSize, (int)realY + y * (int)realCellSize, (int)realCellSize, (int)realCellSize);
    }

    @Override
    public void drawPiece(Graphics graphics, GridWidget gridWidget, Piece piece, int opacity) {
        Block[][] blocks = piece.getBlocks();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j].getType() != BlockType.EMPTY) {
                    drawBlock(graphics, gridWidget, blocks[i][j], piece.getX() + j, piece.getY() + i, opacity);
                }
            }
        }

    }


    @Override
    public void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid, Piece currentPiece) {
        for (int i = 0; i < grid.getNbRows(); i++) {
            for (int j = 0; j < grid.getNbColumns(); j++) {
                Block block = grid.getBlock(i, j);
                drawBlock(graphics, gridWidget, block, j, i, 255);
            }
        }
        drawPiece(graphics, gridWidget, currentPiece, 255);
        drawPiece(graphics, gridWidget, gridWidget.getParty().getGhostPiece(), 100);
    }

    @Override
    public void drawBackground(Graphics graphics){
        graphics.setColor(Color.YELLOW);
        graphics.fillRect( 0, 0, width , height);

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
