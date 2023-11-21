import controller.display.Display;
import controller.widget.GridWidget;
import model.game.Game;
import view.screen.Screen;
import view.theme.ClassicTheme;
import view.theme.Theme;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Tetris {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
               public void run() {
                   Theme theme = new ClassicTheme();
                   Game game = new Game();
                   Display display = new Display(theme);
                   GridWidget gridWidget = new GridWidget(30, 8, 80, game.party);
                   display.widgets.add(gridWidget);
                   Screen screen = new Screen(800, 800, game);
                   screen.addDisplay(display);
                   screen.setVisible(true);
               }
           }
        );
    }
}