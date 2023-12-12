package model.game;


import model.party.Party;
import model.scheduler.Scheduler;

import java.awt.event.KeyEvent;
import java.util.Observable;

public class Game extends Observable implements Runnable {

    private Scheduler scheduler = new Scheduler(this, 50);
    public Party party = new Party();
    public Party partyDuo = new Party();

    public boolean pause = false;
    public boolean duo = false;

    public Game() {
        scheduler.start();
    }

    public void keyPressed(KeyEvent keyEvent, boolean player) {
        if(player){
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT -> party.moveLeft();
                case KeyEvent.VK_RIGHT -> party.moveRight();
                case KeyEvent.VK_DOWN -> {
                    party.moveDown();
                    if (party.canMoveDown())
                        party.addScore(1);
                }
                case KeyEvent.VK_UP -> party.rotate();
                case KeyEvent.VK_SPACE -> party.hardDrop();
                case KeyEvent.VK_H -> party.holdPiece();
            }
        }else{
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_Q -> partyDuo.moveLeft();
                case KeyEvent.VK_D -> partyDuo.moveRight();
                case KeyEvent.VK_S -> {
                    partyDuo.moveDown();
                    if (partyDuo.canMoveDown())
                        partyDuo.addScore(1);
                }
                case KeyEvent.VK_Z -> partyDuo.rotate();
                case KeyEvent.VK_A -> partyDuo.hardDrop();
                case KeyEvent.VK_E -> partyDuo.holdPiece();
            }
        }
    }

    public boolean partiesOver() {
        return !party.getAlive();
    }
    public boolean partiesDuoOver() {
        return !partyDuo.getAlive();
    }

    @Override
    public void run() {
        if(!pause) {
            party.update(scheduler.getMsElapsed());
            if (duo) partyDuo.update(scheduler.getMsElapsed());
        }
        setChanged();
        notifyObservers();
    }
}
