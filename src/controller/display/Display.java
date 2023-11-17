package controller.display;

import controller.widget.Widget;
import model.game.Game;
import view.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Display implements Observer {
    public ArrayList<Widget> widgets;

    protected Theme theme;

    protected Game game;

    public Display(Theme theme, Game game) {
        widgets = new ArrayList<>();
        this.theme = theme;
        this.game = game;
    }

    public void draw(Graphics graphics, Game game) {
        for (Widget graphicElement : widgets) {
            graphicElement.paint(graphics, theme, game);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

        for (Widget widget : widgets) {
            BufferStrategy bs = widget.getBufferStrategy(); // bs + dispose + show : double buffering pour éviter les scintillements
            if (bs == null) {
                widget.createBufferStrategy(2);
                return;
            }
            Graphics g = bs.getDrawGraphics();
            widget.paint(g, theme, game); // appel de la fonction pour dessiner
            g.dispose();
            //Toolkit.getDefaultToolkit().sync(); // forcer la synchronisation
            bs.show();
        }

    }

}
