package racingcar.model;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if(name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
