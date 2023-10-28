package racingcar;

import java.util.List;

public class Validator {

    private static final String WORNG_CAR_LENGTH = "이름은 5자 이하만 가능해요.";
    private static final String WORNG_COUNT_RANDE = "최소 시도 횟수는 1번이에요.";

    //false일때 오류
    public void validatorForCar(List<String> cars) {
        //5자 이하인가?
        if (!isMaxSizeName(cars)) {
            throw new IllegalArgumentException(WORNG_CAR_LENGTH);
        }
    }

    public void validatorForAttemptCount(int count) {
        //0이상인가?
        if (!isVaildRange(count)) {
            throw new IllegalArgumentException(WORNG_COUNT_RANDE);
        }
    }

    private boolean isMaxSizeName(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private boolean isVaildRange(int count) {
        if (count <= 0) {
            return false;
        }
        return true;
    }


}
