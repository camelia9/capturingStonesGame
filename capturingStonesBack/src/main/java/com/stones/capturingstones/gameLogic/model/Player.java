package com.stones.capturingstones.gameLogic.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public record Player(PlayerNumber number, List<SmallPit> smallPits, BigPit bigPit) {
    public Pit turn(int smallPitNum){
        SmallPit smallPit = getSmallPit(smallPitNum);
        if(smallPit.getStones() == 0){
            throw new IllegalArgumentException("The chosen pit must contain stones!");
        }
        return takeTurn(smallPit);
    }

    private Pit takeTurn(SmallPit smallPit){
        Integer stones = smallPit.collectStones();
        Pit pit = smallPit;
        while (stones > 0) {
            pit = pit.getNextPit();
            if (pit.isSowable(number)) {
                stones -= 1;
                pit.sowStones();
            };

        }
        return pit;
    }

    private SmallPit getSmallPit(int smallPitNum){
        if (smallPitNum < 1 || smallPitNum > smallPits.size()) {
            throw new IllegalArgumentException("House number must be between 1 and " + smallPits.size());
        }
        return this.smallPits.get(smallPitNum - 1);
    }

    public boolean complete() {
        return smallPits.stream().allMatch(SmallPit::isEmpty);
    }

    public void finish() {
        for (SmallPit smallPit: smallPits) {
            bigPit.sowStones(smallPit.take());
        }
    }

    public int score() {
        return bigPit.getStones();
    }

    public PlayerNumber getNumber() {
        return number;
    }


    public List<SmallPit> getSmallPits() {
        return smallPits;
    }


    public BigPit getBigPit() {
        return bigPit;
    }
}
