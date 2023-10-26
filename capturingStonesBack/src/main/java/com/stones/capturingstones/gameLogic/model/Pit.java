package com.stones.capturingstones.gameLogic.model;

public abstract class Pit {

    protected int stones;

    public Pit(int stones) {
        this.stones = stones;
    }

    public int getStones() {
        return stones;
    }

    public void sowStones(){
        this.stones += 1;
    }
}
