package com.stones.capturingstones.gameLogic.model;

public class SmallPit extends Pit{

    public SmallPit(int stones) {
        super(stones);
    }

    public Integer collectStones() {
        int currentStones = this.stones;
        this.stones = 0;
        return currentStones;
    }

}
