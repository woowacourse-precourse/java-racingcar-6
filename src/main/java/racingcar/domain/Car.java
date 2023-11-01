package racingcar.domain;

import racingcar.util.ErrorMessage;

public class Car {

    private final String name;
    private int position;

    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        validateNameNullOrEmpty(name);
        validateNameNoWhitespace(name);
        validateNameLength(name);

        this.name = name;
        this.position = 0;
    }

    private void validateNameNullOrEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NULL_OR_EMPTY.getMessage());
        }
    }

    private void validateNameNoWhitespace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NO_WHITESPACE.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MAX_LENGTH.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void run(int number) {
        if (isMovable(number)) {
            this.position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }
}
