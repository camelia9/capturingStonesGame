package com.stones.capturingstones.gameLogic.model;

import java.util.Optional;

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

    abstract boolean isSowable(PlayerNumber player);

    public void sowStones(){
        this.stones += 1;
    }

    public Pit getNextPit() {
        return nextPit;
    }

    public void setNextPit(Pit nextPit) {
        this.nextPit = nextPit;
    }

    public Optional<SmallPit> getOpposite() {
        return Optional.empty();
    }

    public Integer capture() {
        if (this.getOpposite().isEmpty()) {
            return 0;
        }
        return this.getOpposite().get().collectStones();
    }

    public boolean isEmpty() {
        return this.stones == 0;
    }

    public Integer collectStones() {
        return 0;
    }
}
