package controller.widget;

import view.theme.Theme;

import java.awt.*;

public class ButtonWidget extends  Widget {

    public boolean selected = false;

    private String text;

    public ButtonWidget(int x, int y, int propWidth, int propHeight, String text) {
        super(x, y, propWidth, propHeight);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void paint(Graphics g, Theme theme) {
        theme.drawButton(g, this);
    }
}
