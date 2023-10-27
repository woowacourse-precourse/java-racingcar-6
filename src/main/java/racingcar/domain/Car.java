package racingcar.domain;

public class Car {

    private final String carName;

    private int location = 1;

    private static final int CAR_NAME_LIMIT = 5;

    public Car(String carName) {
        this.carName = validationLimitLength(carName);
    }

    private String validationLimitLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 입력해 주세요.");
        }
        return carName;
    }

    public String getCarName() {
        return carName;
    }
}
