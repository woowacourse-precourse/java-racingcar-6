package racingcar.domain;

import racingcar.constant.ActionConstant;

public class Car {

    private static final int STANDARD_NUMBER = 4;
    private String name;
    private int moveNumber = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int diceNumber){
        if (diceNumber >= STANDARD_NUMBER){
            moveNumber++;
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + printMove();
    }

    private String printMove(){
        String str = "-";
        return str.repeat(moveNumber);
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public String getName() {
        return name;
    }
}
