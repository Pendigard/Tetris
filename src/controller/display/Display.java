package controller.display;

import controller.menu.Menu;
import controller.widget.*;
import model.game.Game;
import model.party.Party;
import view.theme.ClassicTheme;
import view.theme.SynthwaveTheme;
import view.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Display extends Canvas implements Observer {
    public ArrayList<Widget> widgets;

    protected Theme theme;

    protected int width;
    protected int height;

    protected Menu menu = null;


    public Display(Theme theme) {
        super();
        widgets = new ArrayList<>();
        this.theme = theme;
        this.width = 0;
        this.height = 0;
        theme.playBackgroundMusic();
        menu = null;
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
        if (menu != null) {
            for (ArrayList<ButtonWidget> buttonList : menu.getButtons()) {
                for (ButtonWidget button : buttonList) {
                    button.paint(g, theme);
                }
            }
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

    public void changeMenu(Menu newMenu) {
        menu = newMenu;
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

    public void setDisplaySolo(Party party) {
        widgets.clear();
        BackgroundWidget backgroundWidget = new BackgroundWidget(width, height);
        GridWidget gridWidget = new GridWidget(35, 8, 80, party);
        HeldPieceWidget heldPieceWidget = new HeldPieceWidget(5, 8, 20, party);
        NextPieceWidget nextPieceWidget = new NextPieceWidget(75, 8, 12, 40, party);
        InfoWidget infoWidget = new InfoWidget(5, 62, 20, 25, party);
        widgets.add(backgroundWidget);
        widgets.add(gridWidget);
        widgets.add(heldPieceWidget);
        widgets.add(nextPieceWidget);
        widgets.add(infoWidget);
    }

    public void setDisplayMult(Party party1,Party party2) {
        widgets.clear();
        BackgroundWidget backgroundWidget = new BackgroundWidget(width, height);
        GridWidget gridWidget1 = new GridWidget(15, 8, 72, party1);
        HeldPieceWidget heldPieceWidget1 = new HeldPieceWidget(2, 8, 18, party1);
        NextPieceWidget nextPieceWidget1 = new NextPieceWidget(40, 8, 10, 36, party1);
        InfoWidget infoWidget1 = new InfoWidget(2, 62, 10, 23, party1);

        int decal = 50;
        GridWidget gridWidget2 = new GridWidget(15 + decal, 8, 72, party2);
        HeldPieceWidget heldPieceWidget2 = new HeldPieceWidget(2 + decal, 8, 18, party2);
        NextPieceWidget nextPieceWidget2 = new NextPieceWidget(40 + decal, 8, 10, 36, party2);
        InfoWidget infoWidget2 = new InfoWidget(2 + decal, 62, 10, 23, party2);

        widgets.add(backgroundWidget);
        widgets.add(gridWidget1);
        widgets.add(gridWidget2);
        widgets.add(heldPieceWidget1);
        widgets.add(heldPieceWidget2);
        widgets.add(nextPieceWidget1);
        widgets.add(nextPieceWidget2);
        widgets.add(infoWidget1);
        widgets.add(infoWidget2);
    }

    public void setDisplayMenu() {
        widgets.clear();
        BackgroundWidget backgroundWidget = new BackgroundWidget(width, height);
        widgets.add(backgroundWidget);
    }
}
