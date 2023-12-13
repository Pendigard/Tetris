package controller.menu;

import controller.widget.ButtonWidget;
import view.screen.Screen;

import java.awt.event.KeyEvent;

public class GameOverMenu extends Menu {

    public GameOverMenu() {
        super();
        addButtonX(new ButtonWidget(10, 60, 20, 10, "RESTART"), 0);
        addButtonX(new ButtonWidget(40, 60, 20, 10, "QUIT"), 0);
        choiceX = 0;
        choiceY = 0;
    }
    @Override
    public void update(Screen screen) {
        if (choiceX == 0) {
            screen.game.party.reset();
            screen.inGame = true;
            screen.menu = null;
        }
        else {
            screen.inGame = false;
            screen.menu = new MainMenu();
            screen.display.setDisplayMenu();
        }

    }
}

