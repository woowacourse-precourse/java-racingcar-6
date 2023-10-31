package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    private int moveCount;

    private int score;

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int POSSIBLE_TO_MOVE_NUMBER = 4;

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
        this.score = 0;
    }

    public void getChanceToMove(){
        if(pickRandomNumberToMove()>=POSSIBLE_TO_MOVE_NUMBER) {
            this.score++;
        }
        this.moveCount--;
    }

    private int pickRandomNumberToMove(){
        return Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);
    }

    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }

    public int getMoveCount(){
        return moveCount;
    }
}
