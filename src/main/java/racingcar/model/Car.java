package racingcar.model;

import racingcar.exception.CarNameValidator;
import racingcar.util.CarConstant;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= CarConstant.RANDOM_THRESHOLD) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
