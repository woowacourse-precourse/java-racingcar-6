package racingcar.domain;

import racingcar.config.GameConfig;

public class Car {

    private static final int INIT_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    private static void validateNameLength(String name) {
        if (name.length() > GameConfig.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward(int number) {
        if (number >= GameConfig.MOVING_FORWARD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
