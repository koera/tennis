package com.tdd.tennis;

import static com.tdd.tennis.Score.getLabel;

public class Tennis {

    private final int WIN_POINT = 4;
    private final String COMMA = ",";
    private final int DEUCE_POINT = 3;
    private final String DEUCE = "DEUCE";
    private final String ADVANTAGE = "Advantage for ";

    Player player1;
    Player player2;

    public Tennis(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore(){
        var winner = getWinner();
        var advantage = getAdvantage();

        if(winner != null) {
            return winner.name() + " win";
        }

        if(isDeuce()) {
            return DEUCE;
        }

        if(advantage != null) {
            return ADVANTAGE + advantage.name();
        }

        return getLabel(player1.point()) + COMMA + getLabel(player2.point());
    }

    public Player getWinner() {
        if(isPlayer1Win()) {
            return player1;
        }
        if(isPlayer2Win()){
            return player2;
        }
        return null;
    }

    public boolean isDeuce(){
        return allPlayersHasDeucePoint()
                && player1.point() == player2.point();
    }

    private boolean allPlayersHasDeucePoint(){
        return playerHasAtLeastDeucePoint(player1) && playerHasAtLeastDeucePoint(player2);
    }

    private Player getAdvantage(){
        if (allPlayersHasDeucePoint() && player1HasAdvantage()) return player1;
        if (allPlayersHasDeucePoint() && player2HasAdvantage()) return player2;
        return null;
    }

    private boolean player1HasAdvantage() {
        return player1.point() >= player2.point() + 1;
    }

    private boolean player2HasAdvantage() {
        return player2.point() >= player1.point() + 1;
    }

    private boolean playerHasAtLeastDeucePoint(Player player) {
        return player.point() >= DEUCE_POINT;
    }

    private boolean isPlayer1Win(){
        return player1.point() >= WIN_POINT && player2.point() <= player1.point() - 2;
    }

    private boolean isPlayer2Win(){
        return player2.point() >= WIN_POINT && player1.point() <= player2.point() - 2;
    }
}
