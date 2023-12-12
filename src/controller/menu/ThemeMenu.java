package controller.menu;

import controller.widget.ButtonWidget;
import view.screen.Screen;
import view.theme.ClassicTheme;
import view.theme.SynthwaveTheme;

public class ThemeMenu extends Menu {

    public ThemeMenu() {
        super();
        addButtonY(new ButtonWidget(32, 10, 35, 10, "Classic"));
        addButtonY(new ButtonWidget(32, 30, 35, 10, "Synthwave"));
        addButtonY(new ButtonWidget(32, 50, 35, 10, "Back"));
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
                screen.menu = new MainMenu();
                break;
        }
    }
}
