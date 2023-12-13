package controller.widget;

import view.theme.Theme;

import java.awt.*;

public abstract class Widget {

        protected int propX; // x position in % of the width of the display
        protected int propY; // y position in % of the height of the display
        protected int propWidth; // width in % of the width of the display
        protected int propHeight; // height in % of the height of the display

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

        public int getRealX(int width) {
            return (int)((propX)/100.0 * width);
        }

        public int getRealY(int height) {
            return (int)((propY)/100.0 * height);
        }

        public int getRealWidth(int width) {
            return (int)((propWidth)/100.0 * width);
        }

        public int getRealHeight(int height) {
            return (int)((propHeight)/100.0 * height);
        }

        public abstract void paint(Graphics g, Theme theme);
}
