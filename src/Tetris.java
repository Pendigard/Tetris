import controller.display.Display;
import controller.widget.*;
import model.game.Game;
import view.screen.Screen;
import view.theme.ClassicTheme;
import view.theme.SynthwaveTheme;
import view.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Tetris {

    public void loadFonts() throws IOException, FontFormatException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font vcr_osd_mono = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/vcr_osd_mono.ttf"));
        ge.registerFont(vcr_osd_mono);
    }
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
               public void run() {
                   int width = 800;
                   int height = 800;
                   Theme theme = new ClassicTheme();
                   Game game = new Game();
                   Display display = new Display(theme);
                   BackgroundWidget backgroundWidget = new BackgroundWidget(width, height);
                   GridWidget gridWidget = new GridWidget(30, 8, 80, game.party);
                   HeldPieceWidget heldPieceWidget = new HeldPieceWidget(5, 8, 20, game.party);
                   NextPieceWidget nextPieceWidget = new NextPieceWidget(75, 8, 40, 20, game.party);
                   InfoWidget infoWidget = new InfoWidget(5, 62, 25, 20, game.party);
                   display.widgets.add(backgroundWidget);
                   display.widgets.add(gridWidget);
                   display.widgets.add(heldPieceWidget);
                   display.widgets.add(nextPieceWidget);
                   display.widgets.add(infoWidget);
                   Screen screen = new Screen(width, height, game);
                   screen.setBackground(Color.BLACK);
                   screen.addDisplay(display);
                   screen.getFocusListeners();
                   screen.setVisible(true);
               }
           }
        );
    }
}