package racingcar.model;

import java.util.List;

public class CarGroupValidator {
    private static final Integer MIN_CAR_COUNT = 1;
    private static final String CAR_COUNT_ERROR = "최소 1개 이상의 자동차를 입력해야 합니다.";

    public static void validate(List<String> names) {
        validateCarCount(names);
    }

    private static void validateCarCount(List<String> names) {
        if (names.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }
    }
}
