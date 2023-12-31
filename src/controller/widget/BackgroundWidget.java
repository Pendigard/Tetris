package controller.widget;

import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public class BackgroundWidget extends Widget {
    // Widget that displays the game grid and the current piece
    public BackgroundWidget(int width ,int height) {
        super(0, 0, width, height);
    }

    @Override
    public void paint(Graphics g, Theme theme) {
        theme.drawBackground(g);
    }
}
