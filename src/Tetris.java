import controller.display.Display;
import controller.widget.GridWidget;
import controller.widget.BackgroundWidget;
import controller.widget.HeldPieceWidget;
import model.game.Game;
import view.screen.Screen;
import view.theme.ClassicTheme;
import view.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Tetris {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
               public void run() {
                   int width = 800;
                   int height = 800;
                   Theme theme = new ClassicTheme();
                   Game game = new Game();
                   Display display = new Display(theme);
                   BackgroundWidget backgroundWidget = new BackgroundWidget(width, height, game.party);
                   GridWidget gridWidget = new GridWidget(30, 8, 80, game.party);
                   HeldPieceWidget heldPieceWidget = new HeldPieceWidget(5, 8, 20, game.party);
                   display.widgets.add(backgroundWidget);
                   display.widgets.add(gridWidget);
                   display.widgets.add(heldPieceWidget);
                   Screen screen = new Screen(width, height, game);
                   screen.setBackground(Color.BLACK);
                   screen.addDisplay(display);
                   screen.setVisible(true);
               }
           }
        );
    }
}