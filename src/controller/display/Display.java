package controller.display;

import controller.widget.Widget;
import model.game.Game;
import view.theme.SynthwaveTheme;
import view.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Display extends Canvas implements Observer {
    public ArrayList<Widget> widgets;

    protected Theme theme;

    protected int width;
    protected int height;


    public Display(Theme theme) {
        super();
        widgets = new ArrayList<>();
        this.theme = theme;
        this.width = 0;
        this.height = 0;
        theme.playBackgroundMusic();
    }

    public Display(Theme theme, int width, int height) {
        widgets = new ArrayList<>();
        this.theme = theme;
        this.width = width;
        this.height = height;
        theme.playBackgroundMusic();
    }

    public void setDisplaySize(int width, int height) {
        this.width = width;
        this.height = height;
        theme.setThemeSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Widget widget : widgets) {
            widget.paint(g, theme);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        BufferStrategy bs = getBufferStrategy(); // bs + dispose + show : double buffering pour éviter les scintillements
        if (bs == null) {
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        paint(g);
        g.dispose();
        //Toolkit.getDefaultToolkit().sync(); // forcer la synchronisation
        bs.show();
    }

    public void changeTheme(Theme newTheme) {
        theme.stopBackgroundMusic();
        theme = newTheme;
        theme.playBackgroundMusic();
        theme.setThemeSize(width, height);
    }

    public Theme getTheme() {
        return theme;
    }
}
