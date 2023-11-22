package controller.widget;

import view.theme.Theme;

import java.awt.*;

public abstract class Widget {

        protected int propX;
        protected int propY;
        protected int propWidth;
        protected int propHeight;

        public Widget(int x, int y, int propWidth, int propHeight) {
            this.propX = x;
            this.propY = y;
            this.propWidth = propWidth;
            this.propHeight = propHeight;
        }

        public int getPropWidth() {
            return propWidth;
        }

        public int getPropHeight() {
            return propHeight;
        }

        public int getPropX() {
            return propX;
        }

        public int getPropY() {
            return propY;
        }

        public abstract void paint(Graphics g, Theme theme);
}
