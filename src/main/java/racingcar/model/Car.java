package racingcar.model;

public class Car {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;

    public Car(String name) {
        validationCarName(name);
        this.name = name;
    }

    private void validationCarName(String carName) {
        if (carName.isEmpty() || carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    public String getName() {
        return name;
    }
}
