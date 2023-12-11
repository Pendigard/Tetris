package controller.menu;

import controller.display.Display;
import controller.widget.ButtonWidget;
import view.screen.Screen;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        addButtonY(new ButtonWidget(32, 10, 35, 10, "Solo"));
        addButtonY(new ButtonWidget(32, 30, 35, 10, "Duo"));
        addButtonY(new ButtonWidget(32, 50, 35, 10, "Options"));
        addButtonY(new ButtonWidget(32, 70, 35, 10, "Quit"));
    }
    @Override
    public void update(Screen screen) {
        if (choiceY == 0) {
            screen.game.party.reset();
            screen.inGame = true;
            screen.menu = null;
            screen.pause = false;
            screen.display.setDisplaySolo(screen.game.party);
        }
        if (choiceY == 3) {
            System.exit(0);
        }
    }
}
