package com.stones.capturingstones.gameLogic.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {
    public record Players(Player player1, Player player2) {}
    private List<SmallPit>  smallPits;
    private List<BigPit> bigPits;

    private Players players;

    public Board() {
    }

    public static Board initialiseBoard() {
        return initialiseBoard(6, 6);
    }

    public static Board initialiseBoard(int stones, int length){
        LinkedList<SmallPit> smallPitsOne = buildSmallPits(PlayerNumber.ONE, stones, length);
        LinkedList<SmallPit> smallPitsTwo = buildSmallPits(PlayerNumber.TWO, stones, length);
        setOpposites(smallPitsOne, smallPitsTwo);
        BigPit bigPitOne = new BigPit(PlayerNumber.ONE);
        BigPit bigPitTwo = new BigPit(PlayerNumber.TWO);
        createPitsOrder(smallPitsOne, bigPitOne, smallPitsTwo, bigPitTwo);

        Player playerOne = new Player(PlayerNumber.ONE, smallPitsOne, bigPitOne);
        Player playerTwo = new Player(PlayerNumber.TWO, smallPitsTwo, bigPitTwo);

        Board board = new Board();
        board.smallPits = new ArrayList<>(smallPitsOne);
        board.smallPits.addAll(smallPitsTwo);
        board.bigPits = List.of(bigPitOne, bigPitTwo);
        board.players = new Players(playerOne, playerTwo);

        return board;
    }

    private static LinkedList<SmallPit> buildSmallPits(PlayerNumber playerNumber, int stones, int length) {
        LinkedList<SmallPit> smallPits = new LinkedList<>();
        smallPits.addLast(new SmallPit(playerNumber, stones));
        while (smallPits.size() < length) {
            SmallPit smallPit = new SmallPit(playerNumber, stones);
            smallPits.addLast(smallPit);
        }
        return smallPits;
    }

    private static void setOpposites(LinkedList<SmallPit> smallPitsOne, LinkedList<SmallPit> smallPitsTwo){
        for(SmallPit smallPitOne: smallPitsOne){
            SmallPit smallPitTwo = smallPitsTwo.get(smallPitsTwo.size() - smallPitsOne.indexOf(smallPitOne) - 1);
            smallPitOne.setOppositePit(smallPitTwo);
            smallPitTwo.setOppositePit(smallPitOne);
        }
    }

    private static void createPitsOrder(LinkedList<SmallPit> smallPitsOne, BigPit bigPitOne, LinkedList<SmallPit> smallPitsTwo,  BigPit bigPitTwo){
        for(int i = 0; i < smallPitsOne.size() - 1; i++){
            smallPitsOne.get(i).setNextPit(smallPitsOne.get(i + 1));
            smallPitsTwo.get(i).setNextPit(smallPitsTwo.get(i + 1));
        }

        smallPitsOne.getLast().setNextPit(bigPitOne);
        bigPitOne.setNextPit(smallPitsTwo.getFirst());
        smallPitsTwo.getLast().setNextPit(bigPitTwo);
        bigPitTwo.setNextPit(smallPitsOne.getFirst());
    }

    public List<SmallPit> getSmallPits() {
        return smallPits;
    }

    public List<BigPit> getBigPits() {
        return bigPits;
    }

    public Players getPlayers() {
        return players;
    }
}
