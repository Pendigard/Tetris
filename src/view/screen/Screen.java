package view.screen;

import controller.display.Display;
import controller.menu.GameOverMenu;
import controller.menu.Menu;
import controller.menu.PauseMenu;
import model.game.Game;
import view.theme.ClassicTheme;
import view.theme.SynthwaveTheme;
import view.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Screen extends JFrame implements Observer {

        public Display display;

        public Game game;

        public boolean inGame = false;

        public boolean pause = false;

        public Menu menu = null;

        public Screen(int width, int height, Game game) {
            super("Tetris");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(width, height);
            display = null;
            this.game = game;
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) { //évènement clavier : object contrôleur qui réceptionne
                    super.keyPressed(e);
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        if (display.getTheme().getClass() == SynthwaveTheme.class)
                            display.changeTheme(new ClassicTheme());
                        else
                            display.changeTheme(new SynthwaveTheme());
                    }
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        if (inGame) {
                            if (pause) {
                                menu = null;
                                pause = false;
                                game.pause = false;
                            }
                            else {
                                menu = new PauseMenu();
                                pause = true;
                                game.pause = true;
                            }
                        }
                    }
                    if (inGame && !pause) {
                        game.keyPressed(e);
                    }
                    else {
                        if (menu != null)
                            menu.getInput(e);
                    }
                }
            });

            addComponentListener(new java.awt.event.ComponentAdapter() {
                public void componentResized(java.awt.event.ComponentEvent evt) {
                    if (display != null)
                        display.setDisplaySize(getWidth(), getHeight());
                }
            });
            this.game.addObserver(this);
        }

        public void addDisplay(Display display) {
            this.display = display;
            display.changeMenu(menu);
            game.addObserver(this.display);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(display, BorderLayout.CENTER);
            setContentPane(panel);
            display.setDisplaySize(getWidth(), getHeight());
        }

        public void enter() {
            if (menu.getEnter()) {
                menu.update(this);
            }
        }

    @Override
    public void update(Observable o, Object arg) {
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                if (inGame) {
                    if (game.partiesOver()) {
                        inGame = false;
                        menu = new GameOverMenu();
                    }
                }
                if (display != null) {
                    display.changeMenu(menu);
                    requestFocus();
                    //display.requestFocusInWindow();
                    display.update(o, arg);
                }
                if (menu != null)
                    enter();
            }
        });

    }
}

