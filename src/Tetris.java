import controller.display.Display;
import controller.menu.MainMenu;
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

    public static void loadFonts() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font vcr_osd_mono = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/VCR_OSD_MONO_1.001.ttf"));
            // name : VCR OSD Mono
            ge.registerFont(vcr_osd_mono);
        }
        catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
               public void run() {
                   int width = 1200;
                   int height = 800;
                   Theme theme = new ClassicTheme();
                   Game game = new Game();
                   Display display = new Display(theme);
                   display.setDisplayMenu();
                   loadFonts();
                   Screen screen = new Screen(width, height, game);
                   screen.setBackground(Color.BLACK);
                   screen.addDisplay(display);
                   screen.menu = new MainMenu();
                   screen.getFocusListeners();
                   screen.setVisible(true);
               }
           }
        );
    }
}