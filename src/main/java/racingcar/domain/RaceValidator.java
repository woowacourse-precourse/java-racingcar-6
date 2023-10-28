package racingcar.domain;

import java.util.List;

public class RaceValidator {
    private static final int MIN_CAR_COUNT = 2;
    private static final String CAR_COUNT_EXCEPTION_MESSAGE =
            String.format("Error: 자동차의 개수는 %d대 이상이어야 합니다.", MIN_CAR_COUNT);

    private RaceValidator() {}

    public static void validateCarCount(List<CarName> carNames) {
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
