package com.stones.capturingstones;

import com.stones.capturingstones.gameLogic.CaptureStonesGame;
import com.stones.capturingstones.gameLogic.model.BigPit;
import com.stones.capturingstones.gameLogic.model.Pit;
import com.stones.capturingstones.gameLogic.model.Player;
import com.stones.capturingstones.gameLogic.model.SmallPit;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.stones.capturingstones.gameLogic.model.PlayerNumber.ONE;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private CaptureStonesGame game;

    @Test
    void playerShouldSowSeedsOnTurn() {
        SmallPit last = new SmallPit(ONE, 0);
        SmallPit middle = new SmallPit(ONE,0);
        SmallPit first = new SmallPit(ONE,2);
        BigPit end = new BigPit(ONE);

        first.setNextPit(middle);
        middle.setNextPit(last);
        last.setNextPit(end);

        Player player = new Player(ONE, List.of(first, middle, last), end);
        Pit landed = player.turn(1);

        assertThat(landed).isEqualTo(last);
        assertThat(first.getStones()).isZero();
        assertThat(middle.getStones()).isEqualTo(1);
        assertThat(last.getStones()).isEqualTo(1);
    }
}
