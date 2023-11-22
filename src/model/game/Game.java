package model.game;


import model.party.Party;
import model.scheduler.Scheduler;

import java.awt.event.KeyEvent;
import java.util.Observable;

public class Game extends Observable implements Runnable {

    private Scheduler scheduler = new Scheduler(this, 10);
    public Party party = new Party();

    public Game() {
        scheduler.start();
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT -> party.moveLeft();
            case KeyEvent.VK_RIGHT -> party.moveRight();
            case KeyEvent.VK_DOWN -> {
                party.moveDown();
                party.addScore(1);
            }
            case KeyEvent.VK_UP -> party.rotate();
            case KeyEvent.VK_SPACE -> party.hardDrop();
            case KeyEvent.VK_H -> party.holdPiece();
        }
    }

    @Override
    public void run() {
        party.update(scheduler.getMsElapsed());
        setChanged();
        notifyObservers();
    }
}
