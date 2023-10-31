package racingcar.model;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNameNotEmpty(name);
        checkNameLength(name);
    }

    private void checkNameNotEmpty(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }

    private void checkNameLength(String name) {
        if(name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
