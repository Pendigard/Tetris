import controller.display.Display;
import controller.widget.GridWidget;
import model.game.Game;
import view.screen.Screen;
import view.theme.ClassicTheme;
import view.theme.Theme;

import javax.swing.*;

public class Tetris {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   Theme theme = new ClassicTheme();
                   Game game = new Game();
                   Screen screen = new Screen(800, 800, game);
                   Display display = new Display(theme);
                   GridWidget gridWidget = new GridWidget(30, 8, 80, game.party);
                   display.widgets.add(gridWidget);
                   screen.addDisplay(display);
                   game.addObserver(screen);
                   screen.setVisible(true);
               }
           }
        );
    }
}