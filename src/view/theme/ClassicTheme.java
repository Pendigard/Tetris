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
            default -> new Color(10, 39, 66, 255);
        };
    }

    @Override
    public void drawBlock(Graphics graphics, Block block, int blockSize, int x, int y, int opacity) {
        Color color = getColor(block);
        graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity));
        graphics.fillRect( x, y, blockSize, blockSize);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, blockSize, blockSize);
    }

    @Override
    public void drawPiece(Graphics graphics, int blockSize, int x, int y, Piece piece, int opacity) {
        Block[][] blocks = piece.getBlocks();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j].getType() != BlockType.EMPTY) {
                    drawBlock(graphics, blocks[i][j], blockSize, x + j * blockSize, y + i * blockSize, opacity);
                }
            }
        }

    }

    @Override
    public void drawHeldPiece(Graphics graphics, HeldPieceWidget heldPieceWidget, int opacity) {
        Piece piece = heldPieceWidget.getParty().getHeldPiece();
        int x = heldPieceWidget.getRealX(width);
        int y = heldPieceWidget.getRealY(height);
        if (piece != null) {
            int blockSize = heldPieceWidget.getRealHeight(height) / piece.getBlocks().length;
            drawPiece(graphics, blockSize, x, y, piece, opacity);
        }
    }


    @Override
    public void drawGrid(Graphics graphics, GridWidget gridWidget, Grid grid, Piece currentPiece) {
        Color borderColor = new Color(10, 39, 66, 255);
        int x = gridWidget.getRealX(width);
        int y = gridWidget.getRealY(height);
        int blockSize = gridWidget.getRealHeight(height)/gridWidget.getParty().getGrid().getNbRows();
        drawGridBorder(graphics, gridWidget, 5, borderColor);
        for (int i = 0; i < grid.getNbRows(); i++) {
            for (int j = 0; j < grid.getNbColumns(); j++) {
                Block block = grid.getBlock(i, j);
                drawBlock(graphics, block, blockSize, x+j*blockSize, y+i*blockSize, 255);
            }
        }
        drawPiece(graphics, blockSize, x + currentPiece.getX() * blockSize, y + currentPiece.getY() * blockSize, currentPiece, 255);
        Piece ghostPiece = gridWidget.getParty().getGhostPiece();
        drawPiece(graphics, blockSize, x + ghostPiece.getX() * blockSize, y + ghostPiece.getY() * blockSize, ghostPiece, 100);
    }

    @Override
    public void drawBackground(Graphics graphics){
        Color color = new Color(82, 125, 153, 255);
        graphics.setColor(color);
        graphics.fillRect( 0, 0, width , height);
         /*
        Image background = Toolkit.getDefaultToolkit().getImage("ressources/images/background/city.jpg");
        graphics.drawImage(background, 0, 0, width, height, null);
            */
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
