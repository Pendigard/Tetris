package controller.widget;

import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public class GridWidget extends PartyWidget {

    public GridWidget(int x, int y, int size, Party party) {
        super(x, y, size, party);
    }

    @Override
    public void paint(Graphics g, Theme theme) {
        theme.drawGrid(g, this, party.getGrid(), party.getCurrentPiece());
    }
}
