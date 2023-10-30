package racingcar.domain;

public class Car {

    private static final String CAR_NAME_LENGTH_ERROR = "자동차 이름은 5자 이하만 가능합니다.";
    private String carName;

    Car(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }
}
