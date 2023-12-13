package view.theme;

import java.util.ArrayList;

public class ThemeLoader {

    ArrayList<Theme> themes;

    public ThemeLoader() {
        themes = new ArrayList<>();
        loadDefaultThemes();
    }

    public void loadTheme(Theme theme) {
        themes.add(theme);
    }

    public void loadDefaultThemes() {
        loadTheme(new ClassicTheme());
        loadTheme(new RetroTheme());
        loadTheme(new SynthwaveTheme());
    }

    public ArrayList<Theme> getThemes() {
        return themes;
    }

}
