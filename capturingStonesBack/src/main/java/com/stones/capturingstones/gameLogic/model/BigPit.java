package com.stones.capturingstones.gameLogic.model;

public class BigPit extends Pit{
    public BigPit(int stones) {
        super(0);
    }

    public void sowStones(int stonesToSow){
        this.stones += stonesToSow;
    }
}
