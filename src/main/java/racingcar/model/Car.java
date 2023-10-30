package racingcar.model;

public class Car {
    private static final String MISSING_CAR_NAME_ERROR = "[ERROR] : 자동차 이름을 입력해주세요.";
    private static final String CAR_NAME_LENGTH_LIMIT_ERROR = "[ERROR] : 5글자 이하의 자동차 이름을 입력해주세요";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNonEmptyName(name);
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT_ERROR);
        }
    }

    private void checkNonEmptyName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(MISSING_CAR_NAME_ERROR);
        }
    }

}
