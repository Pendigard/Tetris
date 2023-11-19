package controller.widget;

import model.game.Game;
import model.party.Party;
import view.theme.Theme;

import java.awt.*;

public abstract class Widget extends Canvas {

        protected int propX;
        protected int propY;
        protected int size;

        protected Party party;

        public Widget(int x, int y, int size) {
            this.propX = x;
            this.propY = y;
            this.size = size;
        }

        public int getPropSize() {
            return size;
        }

        public int getPropX() {
            return propX;
        }

        public int getPropY() {
            return propY;
        }

        public abstract void paint(Graphics g, Theme theme);
}
