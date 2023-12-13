package controller.menu;

import controller.widget.ButtonWidget;
import view.screen.Screen;
import view.theme.ClassicTheme;
import view.theme.RetroTheme;
import view.theme.SynthwaveTheme;
import view.theme.ThemeLoader;

public class ThemeMenu extends Menu {

    ThemeLoader themeLoader;

    public ThemeMenu(ThemeLoader themeLoader) {
        super();
        this.themeLoader = themeLoader;
        createThemeButton();
        addButtonY(new ButtonWidget(5, 80, 35, 10, "BACK"));
    }

    public void createThemeButton() {
        /*
        @brief : create a button to change the theme
        @param theme : theme to change
         */
        int nbrButton = Math.min(themeLoader.getThemes().size(),16);
        System.out.println(nbrButton);
        for (int i = 0; i < nbrButton; i+= 4) {
            for (int j = 0; j < 4; j++) {
                if (i + j < themeLoader.getThemes().size()) {
                    addButtonX(new ButtonWidget(5 + 25 * j, 10 + 4 * i, 20, 10, themeLoader.getThemes().get(i + j).getName()), i / 4);
                }
            }
        }
    }

    @Override
    public void update(Screen screen) {
        if (choiceY == buttons.size() - 1) {
            screen.menu = new MainMenu();
        }
        else {
            screen.display.changeTheme(themeLoader.getThemes().get(choiceY*4 + choiceX));
            enter = false;
        }
    }
}
