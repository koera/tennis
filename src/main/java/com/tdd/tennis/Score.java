package com.tdd.tennis;

public enum Score {
    LOVE(0),
    FIFTEEN(1),
    THIRTY(2),
    FORTY(3);

    private int value;

    Score(int value) {
        this.value = value;
    }

    public static String getLabel(int point){
        for(Score score : Score.values()){
            if(score.value == point) return score.name();
        }
        return null;
    }

}
