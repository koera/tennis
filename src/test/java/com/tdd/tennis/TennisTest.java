package com.tdd.tennis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {

    private final int WIN_POINT = 4;

    @Test
    void testTennis__winner_should_be_the_player_win_4_points_and_2_points_more_than_the_opponent__player1_win(){
        var player1Point = WIN_POINT;
        var player2Point = WIN_POINT -2;

        Player player1 = new Player("player1", player1Point);
        Player player2 = new Player("player2", player2Point);

        Tennis game = new Tennis(player1, player2);

        assertEquals(player1, game.getWinner());
    }

    @Test
    void testTennis__winner_should_be_the_player_win_4_points_and_2_points_more_than_the_opponent__player2_win(){
        var player1Point = WIN_POINT -2;
        var player2Point = WIN_POINT;

        Player player1 = new Player("player1", player1Point);
        Player player2 = new Player("player2", player2Point);

        Tennis game = new Tennis(player1, player2);

        assertEquals(player2, game.getWinner());
    }

    @Test
    void testTennis__winner_should_be_null_if_no_winner(){
        var player1Point = WIN_POINT -2;
        var player2Point = WIN_POINT -2;

        Player player1 = new Player("player1", player1Point);
        Player player2 = new Player("player2", player2Point);

        Tennis game = new Tennis(player1, player2);

        assertNull(game.getWinner());
    }
}
