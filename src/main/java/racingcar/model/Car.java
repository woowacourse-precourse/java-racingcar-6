package racingcar.model;

public class Car {
    private static final String MISSING_CAR_NAME_ERROR = "[ERROR] : 자동차 이름을 입력해주세요.";
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNonEmptyName(name);
    }

    private void checkNonEmptyName(String name) {
        if (name==null || name.isEmpty()){
            throw new IllegalArgumentException(MISSING_CAR_NAME_ERROR);
        }
    }

}
