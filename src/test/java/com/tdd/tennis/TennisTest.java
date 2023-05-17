package com.tdd.tennis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {

    private final int WIN_POINT = 4;
    private final String player1Name = "player1";

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
        var noWinPointForPlayer1 = WIN_POINT -2;
        var noWinPointForPlayer2 = WIN_POINT -2;

        Tennis game = playTennis(noWinPointForPlayer1, noWinPointForPlayer2);

        assertNull(game.getWinner());
    }

    @Test
    void testTennis__get_score_return_players_score_label_spared_by_comma(){
        Tennis game = playTennis(3, 2);

        assertEquals("FORTY,THIRTY", game.getScore());
    }

    @Test
    void testTennis__should_return_the_winner_name(){

        Tennis game = playTennis(WIN_POINT, WIN_POINT - 2);

        assertEquals(player1Name + " win", game.getScore());
    }

    private Tennis playTennis(int player1Point, int player2Point) {
        Player player1 = new Player(player1Name, player1Point);
        Player player2 = new Player("player2", player2Point);

        return new Tennis(player1, player2);
    }
}
