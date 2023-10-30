package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;
    private static final String NAME_BLANK_ERROR_MESSAGE = "이름이 존재하지 않습니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 5자 이하만 가능합니다.";
    private static final String NAME_CONTAIN_BLANK_ERROR_MESSAGE = "이름에 공백이 존재하면 안됩니다.";

    private final String name;
    private final Position position;

    public Car(final String name) {
        validate(name);
        this.name = name;
        this.position = new Position();
    }

    private void validate(final String name) {
        validateBlank(name);
        validateLength(name);
        validateContainBlank(name);
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateContainBlank(final String name) {
        if (name.length() != name.strip().length()) {
            throw new IllegalArgumentException(NAME_CONTAIN_BLANK_ERROR_MESSAGE);
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException(NAME_CONTAIN_BLANK_ERROR_MESSAGE);
        }
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            position.moveForward();
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

}
