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

    protected int width = 0;
    protected int height = 0;
    protected Clip backgroundMusic;

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

    public abstract void drawText(Graphics graphics, int x,int y,int size);

    public abstract void drawBackground(Graphics graphics);

    public void drawInfo(Graphics graphics, InfoWidget infoWidget){
        int x = infoWidget.getRealX(width);
        int y = infoWidget.getRealY(height);
        int widgetWidth = infoWidget.getRealHeight(height);
        int widgetHeight = infoWidget.getRealWidth(width);
        drawBox(graphics, x, y, widgetWidth, widgetHeight, 255);
    }

    public void drawHeldPiece(Graphics graphics, HeldPieceWidget heldPieceWidget, int opacity) {
        Piece piece = heldPieceWidget.getParty().getHeldPiece();
        int x = heldPieceWidget.getRealX(width);
        int y = heldPieceWidget.getRealY(height);
        int widgetWidth = heldPieceWidget.getRealHeight(height);
        int widgetHeight = heldPieceWidget.getRealHeight(height);
        drawBox(graphics, x, y, widgetWidth, widgetHeight, opacity);
        if (piece != null) {
            int blockSize = widgetHeight/6;
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
        int widgetWidth = nextPieceWidget.getRealHeight(height);
        int widgetHeight = nextPieceWidget.getRealWidth(width);
        drawBox(graphics, x, y, widgetWidth, widgetHeight, 255);
        Piece[] nextPieces = nextPieceWidget.getParty().getNextPieces();
        int blockSize = widgetWidth/6;
        for (int i = 0; i < 3; i++) {
            int nbrBlocksX = nextPieces[i+1].getPieceBoundingBox()[0].length;
            int pieceX = x + blockSize + (int)((4-nbrBlocksX)*blockSize*0.5); // To center the piece
            int pieceY = y + blockSize + i*blockSize*4;
            drawBoundingPiece(graphics, blockSize, pieceX, pieceY, nextPieces[i+1], 255);
        }
    }


    public abstract void playBackgroundMusic();

    public abstract void stopBackgroundMusic();


}
