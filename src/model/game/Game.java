package model.game;


import model.party.Party;
import model.scheduler.Scheduler;

import java.util.Observable;

public class Game extends Observable implements Runnable {

    private Scheduler scheduler = new Scheduler(this);
    public Party party = new Party();
    private int timeSaver = 0; // Save the time elapsed

    public Game() {
        scheduler.start();
    }

    @Override
    public void run() {
        if (scheduler.getTickElapsed() - timeSaver >= 1000/400) {
            timeSaver = scheduler.getTickElapsed();
            party.moveDown();
        }
        setChanged();
        notifyObservers();
    }
}
