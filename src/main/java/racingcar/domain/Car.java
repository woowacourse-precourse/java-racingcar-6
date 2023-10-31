package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    private int RemainingOpportunity;

    private int movementScore;

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int POSSIBLE_TO_MOVE_NUMBER = 4;

    public Car(String name, int movementOpportunity) {
        this.name = name;
        this.RemainingOpportunity = movementOpportunity;
        this.movementScore = 0;
    }

    public void tryToGetMovementScore(){
        if(pickRandomNumberToMove()>=POSSIBLE_TO_MOVE_NUMBER) {
            this.movementScore++;
        }
        this.RemainingOpportunity--;
    }

    protected int pickRandomNumberToMove(){
        return Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);
    }

    public String getName(){
        return name;
    }

    public int getMovementScore(){ return movementScore; }

    public int getRemainingOpportunity(){
        return RemainingOpportunity;
    }
}
