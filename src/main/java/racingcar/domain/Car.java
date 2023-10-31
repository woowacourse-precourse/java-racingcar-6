package racingcar.domain;

import static racingcar.message.ErrorMessage.*;

public class Car implements CarCondition{

    private final String name;

    private int distance = 0;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    @Override
    public void checkNameLength(String name) {
        if (name.length() > NAME_CONDITION) {
            throw new IllegalArgumentException(EXCEED_NAME_LENGTH.getMessage());
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isMoreThanCondition(int number) {
        return MOVE_CONDITION <= number;
    }

    public void move() {
        distance++;
    }
}
