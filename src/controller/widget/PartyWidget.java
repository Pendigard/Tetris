package controller.widget;

import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public abstract class PartyWidget extends Widget {

    protected Party party;
    public PartyWidget(int x, int y, int size, Party party) {
        super(x, y, size);
        this.party = party;
    }

    public abstract void paint(Graphics g, Theme theme);
}
