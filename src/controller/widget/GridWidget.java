package controller.widget;

import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public class GridWidget extends PartyWidget {
    // Widget that displays the game grid and the current piece
    public GridWidget(int propX, int propY, int propHeightSize, Party party) {
        super(propX, propY, propHeightSize, propHeightSize, party);
    }

    @Override
    public void paint(Graphics g, Theme theme) {
        theme.drawGrid(g, this, party.getGrid(), party.getCurrentPiece());
    }
}
