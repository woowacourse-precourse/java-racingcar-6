package racingcar.entity;

import racingcar.constants.Constants;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name.trim().length() > Constants.MAX_NAME_LENGTH.<Integer>getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= Constants.MIN_MOVE_NUMBER.<Integer>getValue()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
