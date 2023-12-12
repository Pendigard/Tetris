package controller.menu;

import controller.display.Display;
import controller.widget.ButtonWidget;
import view.screen.Screen;
import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract class Menu {
    protected int choiceX = 0;
    protected int choiceY = 0;

    protected boolean enter = false;

    ButtonWidget Title;
    ArrayList<ArrayList<ButtonWidget>> buttons;

    public Menu() {
        buttons = new ArrayList<>();
    }

    protected void updateChoice(int x, int y) {
        assert x >= 0 && x < buttons.size();
        choiceX = x;
        choiceY = y;
    }

    protected void addTitle(ButtonWidget button) {
        Title = button;
    }


    protected void addButtonY(ButtonWidget button) {
        buttons.add(new ArrayList<>());
        buttons.get(buttons.size() - 1).add(button);
    }

    protected void addButtonX(ButtonWidget button, int y) {
        if (y >= buttons.size()) {
            for (int i = buttons.size(); i <= y; i++) {
                buttons.add(new ArrayList<>());
            }
        }
        buttons.get(y).add(button);
    }

    public ArrayList<ArrayList<ButtonWidget>> getButtons() {
        return buttons;
    }

    public void up() {
        choiceY = (choiceY - 1) % buttons.size();
        if (choiceY < 0) {
            choiceY = buttons.size() - 1;
        }
    }

    public void down() {
        choiceY = (choiceY + 1) % buttons.size();
    }

    public void left() {
        choiceX = (choiceX - 1) % buttons.get(choiceY).size();
        if (choiceX < 0) {
            choiceX = buttons.get(choiceY).size() - 1;
        }
    }

    public void right() {
        choiceX = (choiceX + 1) % buttons.get(choiceY).size();
    }

    public void getInput(KeyEvent e) {
        buttons.get(choiceY).get(choiceX).selected = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right();
        }
        buttons.get(choiceY).get(choiceX).selected = true;
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enter = true;
        }
    }

    public boolean getEnter() {
        return enter;
    }


    public abstract void update(Screen screen);
}
