package racingcar.car;

import static racingcar.constants.RacingGameConstants.MIN_VALUE_FOR_MOVE;

public class Car {
    private String name;
    private int currentPosition;


    public Car(String name) {
        this.name = name;
    }
    public void move(int numberToMove) {
        if (numberToMove > MIN_VALUE_FOR_MOVE) {
            currentPosition++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
