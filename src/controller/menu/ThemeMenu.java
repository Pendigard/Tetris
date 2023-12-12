package controller.menu;

import controller.widget.ButtonWidget;
import view.screen.Screen;
import view.theme.ClassicTheme;
import view.theme.RetroTheme;
import view.theme.SynthwaveTheme;

public class ThemeMenu extends Menu {

    public ThemeMenu() {
        super();
        addButtonY(new ButtonWidget(32, 10, 35, 10, "CLASSIC"));
        addButtonY(new ButtonWidget(32, 30, 35, 10, "SYNTHWAVE"));
        addButtonY(new ButtonWidget(32, 50, 35, 10, "RETRO"));
        addButtonY(new ButtonWidget(5, 70, 35, 10, "BACK"));
    }
    @Override
    public void update(Screen screen) {
        switch (choiceY){
            case 0:
                screen.display.changeTheme(new ClassicTheme());
                enter = false;
                break;
            case 1:
                screen.display.changeTheme(new SynthwaveTheme());
                enter = false;
                break;
            case 2:
                screen.display.changeTheme(new RetroTheme());
                enter = false;
                break;
            case 3:
                screen.menu = new MainMenu();
                break;
        }
    }
}
