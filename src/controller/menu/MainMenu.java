package controller.menu;

import controller.display.Display;
import controller.widget.ButtonWidget;
import view.screen.Screen;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        addButtonY(new ButtonWidget(32, 35, 35, 10, "SOLO"));
        addButtonY(new ButtonWidget(32, 50, 35, 10, "DUO"));
        addButtonY(new ButtonWidget(32, 65, 35, 10, "OPTIONS"));
        addButtonY(new ButtonWidget(32, 80, 35, 10, "QUIT"));
    }
    @Override
    public void update(Screen screen) {
        switch (choiceY){
            case 0:
                screen.game.party.reset();
                screen.game.duo = false;
                screen.inGame = true;
                screen.menu = null;
                screen.pause = false;
                screen.display.setDisplaySolo(screen.game.party);
                break;
            case 1:
                screen.game.party.reset();
                screen.game.partyDuo.reset();
                screen.game.duo = true;
                screen.inGame = true;
                screen.menu = null;
                screen.pause = false;
                screen.display.setDisplayMult(screen.game.party,screen.game.partyDuo);
                break;
            case 2:
                screen.menu = new ThemeMenu(screen.themeLoader);
                break;
            case 3:
                System.exit(0);
                break;

        }
    }
}
