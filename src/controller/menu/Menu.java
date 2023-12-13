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
    ArrayList<ArrayList<ButtonWidget>> buttons;

    public Menu() {
        buttons = new ArrayList<>();
    }


    protected void addButtonY(ButtonWidget button) {
        /*
        @brief : add a button to the menu in a new line
        @param button : button to add
         */
        buttons.add(new ArrayList<>());
        buttons.get(buttons.size() - 1).add(button);
    }

    protected void addButtonX(ButtonWidget button, int y) {
        /*
        @brief : add a button to the menu in a new column
        @param button : button to add
        @param y : line where to add the button
         */
        if (y >= buttons.size()) {
            for (int i = buttons.size(); i <= y; i++) {
                buttons.add(new ArrayList<>());
            }
        }
        buttons.get(y).add(button);
    }

    public ArrayList<ArrayList<ButtonWidget>> getButtons() {
        /*
        @brief : get the buttons of the menu
        @return : buttons of the menu
         */
        return buttons;
    }

    protected void up() {
        /*
        @brief : move the selection up
         */
        choiceY = (choiceY - 1) % buttons.size();
        if (choiceY < 0) {
            choiceY = buttons.size() - 1;
        }
    }

    protected void down() {
        /*
        @brief : move the selection down
         */
        choiceY = (choiceY + 1) % buttons.size();
    }

    protected void left() {
        /*
        @brief : move the selection to the left
         */
        choiceX = (choiceX - 1) % buttons.get(choiceY).size();
        if (choiceX < 0) {
            choiceX = buttons.get(choiceY).size() - 1;
        }
    }

    protected void right() {
        /*
        @brief : move the selection to the right
         */
        choiceX = (choiceX + 1) % buttons.get(choiceY).size();
    }

    public void getInput(KeyEvent e) {
        /*
        @brief : get the input of the user
        @param e : key event
         */
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
        /*
        @brief : get if the user pressed enter
        @return : true if the user pressed enter, false otherwise
         */
        return enter;
    }


    public abstract void update(Screen screen);
    /*
    @brief : update the state of the screen according to the choice of the user
    @param screen : screen to update
     */
}
