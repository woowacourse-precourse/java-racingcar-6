package racingcar.model;

public class Car {

    private static final Integer MAX_NAME_LENGTH = 5;
    private final String name;
    private Integer moveCount;

    public Car(String name) {
        validateNameLength(name.length());
        this.name = name;
        this.moveCount = 0;
    }

    private void validateNameLength(Integer nameLength) {
        if (nameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
