package controller.menu;

import controller.widget.ButtonWidget;
import view.screen.Screen;

import java.awt.event.KeyEvent;

public class PauseMenu extends Menu {

    public PauseMenu() {
        super();
        addButtonY(new ButtonWidget(32, 30, 35, 10, "Resume"));
        addButtonY(new ButtonWidget(32, 50, 35, 10, "Quit to menu"));
    }
    @Override
    public void update(Screen screen) {
        if (choiceY == 1) {
            screen.inGame = false;
            screen.menu = new MainMenu();
            screen.pause = false;
            screen.game.pause = false;
            screen.display.setDisplayMenu();
        }
        else {
            screen.menu = null;
            screen.pause = false;
            screen.game.pause = false;
        }
    }
}
