package racingcar.domain;

import racingcar.option.GameOption;

public class Car {
    private final String name;
    private int moveStatus = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= GameOption.STANDARD_NUMBER) {
            moveStatus++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveStatus() {
        return moveStatus;
    }
}
