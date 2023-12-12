package controller.menu;

import controller.widget.ButtonWidget;
import view.screen.Screen;

public class GameOverDuoMenu extends Menu {

    public GameOverDuoMenu(boolean player) {
        super();
        addButtonX(new ButtonWidget(10, 60, 20, 10, "Restart"), 0);
        addButtonX(new ButtonWidget(40, 60, 20, 10, "Quit"), 0);
        addTitle(new ButtonWidget(30, 50, 20, 10, "JIAIJP"));
        choiceX = 0;
        choiceY = 0;
    }
    @Override
    public void update(Screen screen) {
        if (choiceX == 0) {
            screen.game.party.reset();
            screen.game.partyDuo.reset();
            screen.game.pause = false;
            screen.inGame = true;
            screen.menu = null;
        }
        else {
            System.exit(0);
        }

    }
}

