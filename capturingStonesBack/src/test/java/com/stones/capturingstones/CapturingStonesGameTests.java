package com.stones.capturingstones;

import com.stones.capturingstones.gameLogic.CaptureStonesGame;
import com.stones.capturingstones.gameLogic.model.Board;
import com.stones.capturingstones.gameLogic.model.Status;
import org.junit.Before;
import org.junit.Test;


import static com.stones.capturingstones.gameLogic.model.PlayerNumber.ONE;
import static com.stones.capturingstones.gameLogic.model.PlayerNumber.TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapturingStonesGameTests {
    public CaptureStonesGame game;

    @Before
    public void setUp() {
        this.game = CaptureStonesGame.create(Board.initialiseBoard());
    }

    @Test
    public void testNextPlayerMove() {
        CaptureStonesGame.Result result = this.game.move(ONE, 5);
        assertEquals(Status.ACTIVE, result.status());
        assertEquals(TWO, result.next());

    }

}
