package racingcar;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_OVER_NAME_MAX_LENGTH = "자동차 이름은 %d자를 초과할 수 없습니다.".formatted(MAX_NAME_LENGTH);

    private final String name;

    public Car(String name) {
        validateHasText(name);
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_OVER_NAME_MAX_LENGTH);
        }
    }

    private void validateHasText(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
    }
}
