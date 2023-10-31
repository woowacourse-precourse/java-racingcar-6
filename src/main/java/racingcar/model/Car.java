package racingcar.model;

import static racingcar.constant.Constant.RULE_CAR_MOVE;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNum) {
        if (randomNum >= RULE_CAR_MOVE) {
            position++;
        }
    }
}
