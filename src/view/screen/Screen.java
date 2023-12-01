package view.screen;

import controller.display.Display;
import controller.menu.GameOverMenu;
import controller.menu.Menu;
import controller.menu.PauseMenu;
import model.game.Game;
import view.theme.ClassicTheme;
import view.theme.SynthwaveTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Screen extends JFrame implements Observer {

        Display display;

        Game game;

        boolean inGame = true;

        Menu menu = null;

        private void getInput(KeyEvent e) {

        }

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
                            inGame = false;
                            menu = new PauseMenu();
                        }
                        else {
                            inGame = true;
                            menu = null;
                        }
                    }
                    if (inGame) {
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

        public void changeDisplay(Display display) {
            if (this.display != null)
                game.deleteObserver(this.display);
            this.getContentPane().removeAll();
            this.display = display;
            game.addObserver(this.display);
            display.setDisplaySize(getWidth(), getHeight());
        }

    @Override
    public void update(Observable o, Object arg) {
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                game.pause = !inGame;
                if (display != null) {
                    display.changeMenu(menu);
                    requestFocus();
                    //display.requestFocusInWindow();
                    display.update(o, arg);
                }
            }
        });

    }
}

