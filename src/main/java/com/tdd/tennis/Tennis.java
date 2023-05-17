package com.tdd.tennis;

public class Tennis {

    private final int WIN_POINT = 4;

    Player player1;
    Player player2;

    public Tennis(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
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

    private boolean isPlayer1Win(){
        return player1.point() >= WIN_POINT && player2.point() <= player1.point() - 2;
    }

    private boolean isPlayer2Win(){
        return player2.point() >= WIN_POINT && player1.point() <= player2.point() - 2;
    }
}
