package com.stones.capturingstones.gameAPI;
import com.stones.capturingstones.gameLogic.CaptureStonesGame;
import com.stones.capturingstones.gameLogic.MoveRequest;
import com.stones.capturingstones.gameLogic.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/captureStones")
public class CaptureStonesController {
    private CaptureStonesGame game = CaptureStonesGame.create(Board.initialiseBoard());

    @GetMapping("/game-status")
    public Map<String, String> getGameStatus() {
        if (game == null) {
            return Collections.singletonMap("status", "Game not started");
        }

        Map<String, String> response = new HashMap<>();
        response.put("status", game.getStatus().toString());

        return response;
    }

    @GetMapping("/player-turn")
    public Map<String, String> getPlayerTurn() {
        if (game == null) {
            return Collections.singletonMap("status", "Game not started");
        }

        Map<String, String> response = new HashMap<>();
        response.put("player", game.getPlayer().number().toString());

        return response;
    }

    @PostMapping("/make-move")
    public CaptureStonesGame.Result makeMove(@RequestBody MoveRequest moveRequest) {
        if (game == null) {
            return null;
        }

        PlayerNumber playerNumber = moveRequest.getPlayerNumber();
        int smallPit = moveRequest.getSmallPit();

        CaptureStonesGame.Result result = game.move(playerNumber, smallPit);
        return result;
    }

    @GetMapping("/board-values")
    public Map<String, List<Integer>> getBoardValues() {
        if (game == null) {
            return null; // Return an appropriate response for a game that hasn't started yet
        }

        Map<String, List<Integer>> boardValues = new HashMap<>();
        boardValues.put(PlayerNumber.ONE.toString(), getPlayerPitValues(game.getBoard().getPlayers().player1()));
        boardValues.put(PlayerNumber.TWO.toString(), getPlayerPitValues(game.getBoard().getPlayers().player2()));

        return boardValues;
    }

    private List<Integer> getPlayerPitValues(Player player) {
        List<Integer> pitValues = new ArrayList<>();
        for (SmallPit smallPit : player.getSmallPits()) {
            pitValues.add(smallPit.getStones());
        }
        pitValues.add(player.getBigPit().getStones());
        return pitValues;
    }


}
