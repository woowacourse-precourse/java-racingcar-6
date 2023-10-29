package racingcar.domain;

import static racingcar.domain.GameOption.CAR_POSITION_SIGN;

import racingcar.message.ErrorMessage;

public class Car {
    private static final int MAX_NAME_LENGTH = 4;
    private final String name;
    private Position position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = new Position(0);
    }

    private void validateName(String name) {
        validateBlank(name);
        validateNameLength(name);
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }

    public boolean isSamePosition(int position) {
        return this.position.getAmount() == position;
    }

    public void moveForward() {
        position.increment();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getAmount();
    }

    @Override
    public String toString() {
        return name + " : " + CAR_POSITION_SIGN.repeat(position.getAmount());
    }
}
