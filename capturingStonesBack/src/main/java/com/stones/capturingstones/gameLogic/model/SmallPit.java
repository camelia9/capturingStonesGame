package com.stones.capturingstones.gameLogic.model;

public class SmallPit extends Pit{

    private SmallPit oppositePit;

    public SmallPit(PlayerNumber owner, int stones) {
        super(owner, stones);
    }

    public Integer collectStones() {
        int currentStones = this.stones;
        this.stones = 0;
        return currentStones;
    }

    public SmallPit getOppositePit() {
        return oppositePit;
    }

    public void setOppositePit(SmallPit oppositePit) {
        this.oppositePit = oppositePit;
    }

    boolean isSowable(PlayerNumber player) {
        return true;
    }
}
