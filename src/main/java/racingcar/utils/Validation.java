package racingcar.utils;

import java.util.List;

public class Validation {
    private static final Integer MAX_CAR_NAME_LENGTH = 5;
    public static final Integer MIN_TRY_COUNT = 1;
    public Integer validTryCount(Integer tryCount){
        if (tryCount < MIN_TRY_COUNT){
            throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
        }
        return tryCount;
    }
    public List<String> validateCarNames(List<String> carNames) {
        boolean fiveUnder = carNames.stream()
                .anyMatch(name ->name.length() > MAX_CAR_NAME_LENGTH);

        if (fiveUnder) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        return carNames;
    }

}
