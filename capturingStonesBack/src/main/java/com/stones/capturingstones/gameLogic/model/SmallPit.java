package com.stones.capturingstones.gameLogic.model;

import java.util.Optional;

public class SmallPit extends Pit{

    private SmallPit oppositePit;

    public SmallPit(PlayerNumber owner, int stones) {
        super(owner, stones);
    }

    @Override
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


    @Override
    public Optional<SmallPit> getOpposite() {
        return Optional.of(oppositePit);
    }
}
