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
        /*
        @brief : handle the key pressed event
        @param keyEvent : key pressed event
        @param player : true if it's the player 1, false if it's the player 2 and duo mode
         */
        if(player && !partiesOver()){
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
        }
        if(!player && !partiesDuoOver()){
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
    public boolean partiesDuoOver(){
        return !partyDuo.getAlive();
    }
    public boolean allPartiesOver() {
        return !(partyDuo.getAlive() || party.getAlive());
    }

    @Override
    public void run() {
        if(!pause) {
            if(!partiesOver()) party.update(scheduler.getMsElapsed());
            if (duo && !partiesDuoOver()) partyDuo.update(scheduler.getMsElapsed());
        }
        setChanged();
        notifyObservers();
    }
}
