package com.stones.capturingstones;


import com.stones.capturingstones.gameLogic.model.*;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {

        player = new Player(PlayerNumber.ONE, new ArrayList<>(), new BigPit(PlayerNumber.ONE));
    }

    @Test
    public void testShouldCaptureOpposite() {
        SmallPit pit = mock(SmallPit.class);
        when(pit.getStones()).thenReturn(1);
        when(pit.isSowable(PlayerNumber.ONE)).thenReturn(true);

        SmallPit oppositePit = mock(SmallPit.class);
        when(pit.getOpposite()).thenReturn(Optional.of(oppositePit));

        assertTrue(player.shouldCaptureOpposite(pit));
    }


}
