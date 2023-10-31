package racingcar.model;

import static racingcar.validator.InputValidator.validateLenOfCarName;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validateLenOfCarName(name);
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            this.distance += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
