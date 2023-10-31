package com.stones.capturingstones;

import com.stones.capturingstones.gameLogic.CaptureStonesGame;
import com.stones.capturingstones.gameLogic.model.*;
import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapturingStonesGameTests {
    private CaptureStonesGame game;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        Board board = Board.initialiseBoard();
        game = CaptureStonesGame.create(board);
        player1 = board.getPlayers().player1();
        player2 = board.getPlayers().player2();
    }

    @Test
    public void testCreateGame() {
        assertEquals(game.getActivePlayer(), player1);
        assertEquals(game.getStatus(), Status.ACTIVE);
    }

    @Test
    public void testMove() {
        CaptureStonesGame.Result result = game.move(PlayerNumber.ONE, 1);
        assertEquals(result.next(), PlayerNumber.ONE);
        assertEquals(game.getActivePlayer(), player1);

        result = game.move(PlayerNumber.ONE, 2);
        assertEquals(result.next(), PlayerNumber.TWO);
        assertEquals(game.getActivePlayer(), player2);
    }

}
