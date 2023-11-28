package controller.widget;

import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public class NextPieceWidget extends PartyWidget {
    public NextPieceWidget(int x, int y, int width, int height, Party party) {
        super(x, y, width, height, party);
    }

    @Override
    public void paint(Graphics g, Theme theme) {
        theme.drawNextPiece(g, this);
    }
}
