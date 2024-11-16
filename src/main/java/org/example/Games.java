package org.example;

public class Games {
    int [] rolls = new int[22];
    private int currentRoll;

    public void roll(int pins) {
        rolls[currentRoll] +=pins;
        currentRoll++;
    }

    public int score() {
        int score = 0;
        int thisBall= 0;
        for(int i = 0; i < 10; i++) {

            if(isaStrike(thisBall)) {
                score += 10 + rolls[thisBall+1] + rolls[thisBall+2] ;
                thisBall++;

            }
            else if(isSpare(thisBall)) {
                score+= 10 + rolls[thisBall+2];
                thisBall+=2;
            }else{
                score += rolls[thisBall] + rolls[thisBall+1];
                thisBall+=2;

            }
        }
        return score;
    }

    private boolean isSpare(int thisBall) {
        return rolls[thisBall] + rolls[thisBall + 1] == 10;
    }

    private boolean isaStrike(int thisBall) {
        return rolls[thisBall] == 10;
    }
}
