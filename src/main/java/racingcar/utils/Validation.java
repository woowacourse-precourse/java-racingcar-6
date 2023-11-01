package racingcar.utils;

import java.util.List;

import static racingcar.utils.Constants.MAX_CAR_NAME_LENGTH;
import static racingcar.utils.Constants.MIN_TRY_COUNT;

public class Validation {
    public Integer validateTryCount(Integer tryCount){
        if (tryCount < MIN_TRY_COUNT){
            throw new IllegalArgumentException("시도할 회수는 " + MIN_TRY_COUNT + " 이상이어야 합니다.");
        }
        return tryCount;
    }
    public List<String> validateCarNames(List<String> carNames) {
        boolean fiveUnder = carNames.stream()
                .anyMatch(name ->name.length() > MAX_CAR_NAME_LENGTH);

        if (fiveUnder) {
            throw new IllegalArgumentException("자동차 이름은 "+MAX_CAR_NAME_LENGTH+"자 이하여야 합니다.");
        }
        return carNames;
    }

}
