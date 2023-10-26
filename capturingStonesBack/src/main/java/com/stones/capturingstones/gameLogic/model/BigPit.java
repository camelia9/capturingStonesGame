package com.stones.capturingstones.gameLogic.model;

public class BigPit extends Pit{
    public BigPit(PlayerNumber owner) {
        super(owner, 0);
    }

    public void sowStones(int stonesToSow){
        this.stones += stonesToSow;
    }
}
