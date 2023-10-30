package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    String name;
    int moveCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw (new IllegalArgumentException());
        }
    }
}
