package view.theme;

import controller.widget.*;
import controller.widget.HeldPieceWidget;
import model.block.Block;
import model.block.BlockType;
import model.grid.Grid;
import model.piece.Piece;

import java.awt.*;
import javax.naming.NamingException;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public abstract class Theme {

    protected String name;

    protected int width = 0;
    protected int height = 0;
    protected String fontName;

    protected Clip backgroundMusic;

    public Theme() {
        name = "Default";
    }

    public Theme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void drawRectBorderSize(Graphics graphics, int x, int y, int width, int height, int borderSize, Color color) {
        graphics.setColor(color);
        for (int i = 0; i < borderSize; i++) {
            graphics.drawRect(x + i, y + i, width - i * 2, height - i * 2);
        }
    }

    public void setThemeSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawGhostPiece(Graphics graphics, GridWidget gridWidget, int opacity) {
        Piece ghostPiece = gridWidget.getParty().getGhostPiece();
        int x = gridWidget.getRealX(width);
        int y = gridWidget.getRealY(height);
        int blockSize = gridWidget.getRealHeight(height)/gridWidget.getParty().getGrid().getNbRows();
        drawPiece(graphics, blockSize, x + ghostPiece.getX() * blockSize, y + ghostPiece.getY() * blockSize, ghostPiece, opacity);
    }

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
        drawGhostPiece(graphics, gridWidget, 100);
        drawPiece(graphics, blockSize, x + currentPiece.getX() * blockSize, y + currentPiece.getY() * blockSize, currentPiece, 255);
    }

    public abstract Color getColor(Block block);

    public abstract void drawBlock(Graphics graphics, Block block, int blockSize, int x, int y, int opacity);

    private void drawPieceBlocks(Graphics graphics, Block[][] blocks, int blockSize, int x, int y, int opacity) {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                if (blocks[i][j].getType() != BlockType.EMPTY)
                    drawBlock(graphics, blocks[i][j], blockSize, x + j * blockSize, y + i * blockSize, opacity);
            }
        }
    }

    public void drawPiece(Graphics graphics, int blockSize, int x, int y, Piece piece, int opacity) {
        Block[][] blocks = piece.getBlocks();
        drawPieceBlocks(graphics, blocks, blockSize, x, y, opacity);
    }

    public void drawBoundingPiece(Graphics graphics, int blockSize, int x, int y, Piece piece, int opacity) {
        Block[][] blocks = piece.getPieceBoundingBox();
        drawPieceBlocks(graphics, blocks, blockSize, x, y, opacity);
    }

    public abstract void drawBox(Graphics graphics, int x, int y, int width, int height, int opacity);

    public void drawText(Graphics graphics, int x,int y,Color c, int size,String txt){
        Font font = new Font(fontName, Font.BOLD, size);
        graphics.setFont(font);
        graphics.setColor(c);
        graphics.drawString(txt, x, y);
    }

    public void drawTextCenteredX(Graphics graphics, int x, int y, int width, Color c, int size,String txt){
        Font font = new Font(fontName, Font.BOLD, size);
        graphics.setFont(font);
        int textWidth = graphics.getFontMetrics().stringWidth(txt);
        drawText(graphics, (x+width/2)-textWidth/2, y, c, size, txt);
    }

    public void drawTextCentered(Graphics graphics, int x, int y, int width, int height, Color c, int size,String txt){
        Font font = new Font(fontName, Font.BOLD, size);
        graphics.setFont(font); // set font to center text
        int textWidth = graphics.getFontMetrics().stringWidth(txt);
        int textHeight = (int)((textWidth/txt.length())*1.5);
        drawText(graphics, (x+width/2)-textWidth/2, (y+height/2)+textHeight/2, c, size, txt);
    }

    public abstract void drawBackground(Graphics graphics);

    public void drawInfo(Graphics graphics, InfoWidget infoWidget){
        int x = infoWidget.getRealX(width);
        int y = infoWidget.getRealY(height);
        int widgetWidth = infoWidget.getRealWidth(width);
        int widgetHeight = infoWidget.getRealHeight(height);
        int size = widgetHeight/10;
        drawBox(graphics, x, y, widgetWidth, widgetHeight, 255);

        drawTextCenteredX(graphics, x,y+widgetHeight/10, widgetWidth, Color.WHITE,size,"LEVEL");
        drawTextCenteredX(graphics, x,y+(widgetHeight/10)*2, widgetWidth, Color.WHITE,size,String.valueOf(infoWidget.getParty().getLevel()));
        drawTextCenteredX(graphics, x,y+(widgetHeight/10)*4, widgetWidth, Color.WHITE,size,"SCORE");
        drawTextCenteredX(graphics, x,y+(widgetHeight/10)*5, widgetWidth, Color.WHITE,size,String.valueOf(infoWidget.getParty().getScore()));
        drawTextCenteredX(graphics, x,y+(widgetHeight/10)*7, widgetWidth, Color.WHITE,size,"LINES");
        drawTextCenteredX(graphics, x,y+(widgetHeight/10)*8, widgetWidth, Color.WHITE,size,String.valueOf(infoWidget.getParty().getLines()));
    }

    public void drawHeldPiece(Graphics graphics, HeldPieceWidget heldPieceWidget, int opacity) {
        Piece piece = heldPieceWidget.getParty().getHeldPiece();
        int x = heldPieceWidget.getRealX(width);
        int y = heldPieceWidget.getRealY(height);
        int widgetWidth = heldPieceWidget.getRealHeight(height);
        int widgetHeight = heldPieceWidget.getRealHeight(height);
        drawBox(graphics, x, y, widgetWidth, widgetHeight, opacity);
        if (piece != null) {
            int blockSize = widgetWidth/6;
            int nbrBlocksX = piece.getPieceBoundingBox()[0].length;
            int nbrBlocksY = piece.getPieceBoundingBox().length;
            int pieceX = x + blockSize + (int)((4-nbrBlocksX)*blockSize*0.5); // To center the piece
            int pieceY = y + blockSize + (int)((4-nbrBlocksY)*blockSize*0.5);
            drawBoundingPiece(graphics, blockSize, pieceX, pieceY, piece, opacity);
        }
    }

    public void drawNextPiece(Graphics graphics, NextPieceWidget nextPieceWidget) {
        int x = nextPieceWidget.getRealX(width);
        int y = nextPieceWidget.getRealY(height);
        int widgetWidth = nextPieceWidget.getRealWidth(width);
        int widgetHeight = nextPieceWidget.getRealHeight(height);
        drawBox(graphics, x, y, widgetWidth, widgetHeight, 255);
        Piece[] nextPieces = nextPieceWidget.getParty().getNextPieces();
        int blockSize = widgetHeight/12;
        for (int i = 0; i < 3; i++) {
            int nbrBlocksX = nextPieces[i+1].getPieceBoundingBox()[0].length;
            int pieceX = x + blockSize + (int)((4-nbrBlocksX)*blockSize*0.5); // To center the piece
            int pieceY = y + blockSize + i*blockSize*4;
            drawBoundingPiece(graphics, blockSize, pieceX, pieceY, nextPieces[i+1], 255);
        }
    }

    public void drawButton(Graphics graphics, ButtonWidget buttonWidget) {
        int x = buttonWidget.getRealX(width);
        int y = buttonWidget.getRealY(height);
        int widgetWidth = buttonWidget.getRealWidth(width);
        int widgetHeight = buttonWidget.getRealHeight(height);
        if (buttonWidget.selected) {
            graphics.setColor(new Color(47, 175, 12, 255));
        }
        else {
            graphics.setColor(new Color(121, 121, 121, 157));
        }
        graphics.fillRect(x, y, widgetWidth, widgetHeight);
        drawTextCentered(graphics, x, y, widgetWidth, widgetHeight, Color.BLACK, widgetHeight/2, buttonWidget.getText());
    }

    public abstract void loadTheme();

    public abstract void playBackgroundMusic();

    public void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }

    public Image loadImage(String path){
        return Toolkit.getDefaultToolkit().getImage(path);
    }

    public void loadFont(String path) throws IOException, FontFormatException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
    }


}
