package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class CarValidator {
    private static final String CAR_NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATE = "자동차 이름은 겹치지 않아야 합니다.";
    private static final String CAR_COUNT_UNDER_1 = "최소 두 대의 자동차가 있어야 게임이 가능합니다.";

    public void validateCarNameLength(List<String> carList) {
        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH);
            }
        }
    }

    public void validateCarNameDuplication(List<String> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE);
        }
    }

    public void validateCarCount(List<String> carList) {
        if (carList.size() <= 1) {
            throw new IllegalArgumentException(CAR_COUNT_UNDER_1);
        }
    }
}
