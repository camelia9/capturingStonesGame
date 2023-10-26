package com.stones.capturingstones.gameLogic;

import com.stones.capturingstones.gameLogic.model.*;

import static com.stones.capturingstones.gameLogic.model.PlayerNumber.ONE;

public class CaptureStonesGame {
    private Board board;
    private Player player;
    private Status status;
    public record Result(Status status, PlayerNumber next, Board board) {}

    public static CaptureStonesGame create(Board board) {

        CaptureStonesGame game = new CaptureStonesGame();
        game.board = board;
        game.player = board.getPlayers().player1();
        game.status = Status.ACTIVE;
        return game;
    }

    public Player getActivePlayer() {
        return player;
    }

    public Result move(PlayerNumber num, int smallPit) {
        if (!player.number().equals(num)) {
            throw new IllegalStateException(String.format("Player %s cannot take their turn yet", num));
        }
        Pit landed = player.turn(smallPit);
        if (player.complete()) {
            otherPlayer().finish();
            status = declareWinner();
        }
        player = nextPlayer(landed);
        return new Result(status, player.number(), board);
    }

    public Player nextPlayer(Pit landed) {
        if (landed.equals(player.bigPit())) {
            return player;
        }
        return otherPlayer();
    }

    private Player otherPlayer() {
        Board.Players players = board.getPlayers();
        return switch (player.number()) {
            case ONE -> players.player2();
            case TWO -> players.player1();
        };
    }

    private Status declareWinner() {
        Board.Players players = board.getPlayers();
        int score1 = players.player1().score();
        int score2 = players.player2().score();
        if (score1 > score2) {
            return Status.PLAYER_ONE_WIN;
        }
        if (score2 > score1) {
            return Status.PLAYER_TWO_WIN;
        }
        return Status.DRAW;
    }

    public static void main(String[] args) {

        CaptureStonesGame game = CaptureStonesGame.create(Board.initialiseBoard());
        CaptureStonesGame.Result result = game.move(ONE, 5);
        System.out.println(result.status);
        System.out.println(result.next());
    }

}
