package racingcar.domain;

public class Car {
    private static final String INVALID_LENGTH = "자동차 이름의 길이는 5자 이하여야합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (5 < name.length()) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }
}
