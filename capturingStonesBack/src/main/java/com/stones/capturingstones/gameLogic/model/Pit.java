package com.stones.capturingstones.gameLogic.model;

public abstract class Pit {

    protected int stones;

    private Pit nextPit;

    protected final PlayerNumber owner;

    public Pit(PlayerNumber owner, int stones) {
        this.owner = owner;
        this.stones = stones;
    }

    public int getStones() {
        return stones;
    }

    public void sowStones(){
        this.stones += 1;
    }

    public Pit getNextPit() {
        return nextPit;
    }

    public void setNextPit(Pit nextPit) {
        this.nextPit = nextPit;
    }
}
