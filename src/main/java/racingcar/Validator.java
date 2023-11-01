package racingcar;

import java.util.Collections;
import java.util.List;

public class Validator {

    private static final String WORNG_CAR_LENGTH = "이름은 5자 이하만 가능해요.";
    private static final String WORNG_DUPLICATE_CAR_NAME = "중복된 자동차 이름이 있어요.";
    private static final String WORNG_COUNT_RANDE = "최소 시도 횟수는 1번이에요.";
    private static final String WORNG_NULL_BETWEEN_COMMMAS = "공백이 포함되었어요.";

    public void validatorForCar(List<String> cars) {
        if (isMaxSizeName(cars)) {
            throw new IllegalArgumentException(WORNG_CAR_LENGTH);
        } else if (isDuplicateName(cars)) {
            throw new IllegalArgumentException(WORNG_DUPLICATE_CAR_NAME);
        } else if (isNullBetweenCommas(cars)) {
            throw new IllegalArgumentException(WORNG_NULL_BETWEEN_COMMMAS);
        }
    }

    public void validatorForAttemptCount(int count) {
        if (isVaildRange(count)) {
            throw new IllegalArgumentException(WORNG_COUNT_RANDE);
        }
    }


    //region 자동자 유효 검사 Section
    private boolean isMaxSizeName(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateName(List<String> cars) {
        return cars.stream()
                .anyMatch(car -> Collections.frequency(cars, car) > 1);
    }

    private boolean isNullBetweenCommas(List<String> cars) {
        return cars.contains("");
    }
    //endregion


    //region 시도 횟수 유효 검사 Section
    private boolean isVaildRange(int count) {
        return count < 1;
    }
    //endregion

}
