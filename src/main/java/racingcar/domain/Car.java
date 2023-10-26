package racingcar.domain;

import racingcar.constant.ActionConstant;

public class Car {

    private String name;
    private int moveNumber = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(String action){
        if (ActionConstant.MOVE.equals(action)){
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
