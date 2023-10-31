package racingcar.valid;

public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validate(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
