package com.stones.capturingstones.gameLogic;

import com.stones.capturingstones.gameLogic.model.PlayerNumber;

public class MoveRequest {
    private PlayerNumber playerNumber;
    private int smallPit;

    public MoveRequest(PlayerNumber playerNumber, int smallPit) {
        this.playerNumber = playerNumber;
        this.smallPit = smallPit;
    }

    public PlayerNumber getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(PlayerNumber playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getSmallPit() {
        return smallPit;
    }

    public void setSmallPit(int smallPit) {
        this.smallPit = smallPit;
    }
}
