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
                   Theme theme = new ClassicTheme("Classic");
                   Game game = new Game();
                   Display display = new Display(theme, game);
                   GridWidget gridWidget = new GridWidget(50, 0, 10);
                   display.widgets.add(gridWidget);
                   Screen screen = new Screen(display);
                   game.addObserver(screen);
                   game.addObserver(display);
                   screen.setVisible(true);
               }
           }
        );
    }
}