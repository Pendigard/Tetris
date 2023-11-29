package controller.widget;

import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public class InfoWidget extends PartyWidget {
    // Widget that displays the game grid and the current piece
    public InfoWidget(int x ,int y, int width, int height, Party party) {
        super(x, y, width, height, party);
    }

    @Override
    public void paint(Graphics g, Theme theme) {
        theme.drawInfo(g,this);
    }
}
