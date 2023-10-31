package racingcar;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private Integer position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }
}
