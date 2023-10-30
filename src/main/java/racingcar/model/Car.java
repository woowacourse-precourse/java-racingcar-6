package racingcar.model;

import racingcar.util.constants.ValidationConstants;

public class Car {
    private String name;
    private int distance;

    public Car(final String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void addPosition() {
        this.distance += 1;
    }

    private void validateName(final String name) {
        if (name.length() > ValidationConstants.CAR_NAME_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
        }
    }
}