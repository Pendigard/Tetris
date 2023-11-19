package controller.widget;

import model.game.Game;
import view.theme.Theme;

import java.awt.*;

public abstract class Widget extends Canvas {

        protected int propX;
        protected int propY;
        protected int size;

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

        public int setPropX(int x) {
            return propX = x;
        }

        public abstract void paint(Graphics g, Theme theme, Game game);
}
