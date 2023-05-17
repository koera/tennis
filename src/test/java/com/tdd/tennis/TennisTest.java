package com.tdd.tennis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {

    private final int WIN_POINT = 4;
    private final String player1Name = "player1";
    private final String player2Name = "player2";

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

    @Test
    void testTennis__should_deuce_if_the_2_players_scored_at_least_3_points_and_the_score_are_equal(){
        var deucePoint = 3;

        Tennis game = playTennis(deucePoint, deucePoint);

        assertTrue(game.isDeuce());
    }

    @Test
    void testTennis__score_should_be_deuce_if_deuce(){
        var deucePoint = 3;

        Tennis game = playTennis(deucePoint, deucePoint);

        assertEquals("DEUCE", game.getScore());
    }

    @Test
    void testTennis__player_1_should_be_advantage(){
        var deucePoint = 3;

        Tennis game = playTennis(deucePoint + 1, deucePoint);

        assertEquals("Advantage for " + player1Name, game.getScore());
    }


    @Test
    void testTennis__player_2_should_be_advantage(){
        var deucePoint = 3;

        Tennis game = playTennis(deucePoint, deucePoint + 1);

        assertEquals("Advantage for " + player2Name, game.getScore());
    }

    private Tennis playTennis(int player1Point, int player2Point) {
        Player player1 = new Player(player1Name, player1Point);
        Player player2 = new Player(player2Name, player2Point);

        return new Tennis(player1, player2);
    }
}
