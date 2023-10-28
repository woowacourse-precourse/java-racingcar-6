package racingcar;

public class InputValidator {
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";

    public void validCarNameLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }
}
