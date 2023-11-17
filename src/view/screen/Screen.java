package view.screen;

import controller.display.Display;
import controller.widget.Widget;
import model.block.Block;
import model.game.Game;
import view.theme.ClassicTheme;
import view.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Screen extends JFrame implements Observer {

        Display display;

        public Screen(Display display) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(1600, 900);
            this.display = display;
            for (Widget widget : this.display.widgets) {
                add(widget);
            }

            //display.draw(getGraphics(), game);
            setVisible(true);
        }

        public void setContentPane(JPanel jp) {
            super.setContentPane(jp);
            setVisible(true);
        }

    @Override
    public void update(Observable o, Object arg) {
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                display.update(o, arg);
            }
        });

    }
}
