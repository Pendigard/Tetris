package view.screen;

import controller.display.Display;
import controller.widget.Widget;
import model.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Screen extends JFrame implements Observer {

        Display display;

        Game game;

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
                    game.keyPressed(e);
                }
            });
            this.game.addObserver(this);
        }

        public void addDisplay(Display display) {
            this.display = display;
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
                if (display != null)
                    display.update(o, arg);
            }
        });

    }
}
