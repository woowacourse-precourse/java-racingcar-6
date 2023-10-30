package racingcar;

import java.util.List;

public class InputValidator {

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_COUNT = 100;
    public static final String INVALID_CAR_COUNT = "자동차 대수는 2 이상 100 이하로 입력해주세요.";

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하로 입력해주세요.";
    public static final String INVALID_CAR_NAME_WHITESPACE = "자동차 이름은 공백을 포함할 수 없습니다.";


    public void validateCarNames(List<String> carNames) {
        validateCarCount(carNames.size());

        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private void validateCarCount(int carCount) {
        if (carCount < MIN_CAR_COUNT || carCount > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT);
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }

        if (carName.contains(" ")) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_WHITESPACE);
        }
    }
}
