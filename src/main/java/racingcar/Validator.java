package racingcar;

import java.util.List;

public class Validator {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public void checkCarName(List<String> input) {
        checkCarNameLength(input);
    }

    private void checkCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다,");
            }
        }
    }
}
