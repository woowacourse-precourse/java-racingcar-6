package racingcar.model;

import racingcar.service.ShiftGear;
import racingcar.util.ValidateLength;

public class Car {
    private static final String MARK = "-";
    private static String name;
    private int currentPosition;

    public Car(String name){
        validateName(name);
        this.name = name;
        this.currentPosition = 0;
    }

    public void move() {
        if (ShiftGear.moveForward()){
            currentPosition++;
        }
    }

    @Override
    public String toString(){
        return this.name + " : " + MARK.repeat(this.currentPosition);
    }

    private void validateName(String name){
        ValidateLength.check(5, name);
    }
}
