package model.game;


import model.party.Party;
import model.scheduler.Scheduler;

import java.awt.event.KeyEvent;
import java.util.Observable;

public class Game extends Observable implements Runnable {

    private Scheduler scheduler = new Scheduler(this);
    public Party party = new Party();
    private int timeSaver = 0; // Save the time elapsed

    public Game() {
        scheduler.start();
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT -> party.moveLeft();
            case KeyEvent.VK_RIGHT -> party.moveRight();
            case KeyEvent.VK_DOWN -> party.moveDown();
            case KeyEvent.VK_UP -> party.rotate();
        }
    }

    @Override
    public void run() {
        if (scheduler.getTickElapsed() - timeSaver >= 1000/100) {
            timeSaver = scheduler.getTickElapsed();
            party.moveDown();
            party.addScore(party.getGrid().checkLine());
        }
        setChanged();
        notifyObservers();
    }
}
