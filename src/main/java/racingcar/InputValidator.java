package racingcar;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void carNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 다섯 글자 이하이어야 합니다.");
        }
    }
}
