package controller.widget;

import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public class HeldPieceWidget extends PartyWidget {

    public HeldPieceWidget(int x, int y, int sideSize, Party party) {
        super(x, y, sideSize, sideSize, party);
    }

    public HeldPieceWidget(int x, int y, int width, int height, Party party) {
        super(x, y, width, height, party);
    }

    @Override
    public void paint(Graphics g, Theme theme) {
        theme.drawHeldPiece(g, this, 255);
    }
}
