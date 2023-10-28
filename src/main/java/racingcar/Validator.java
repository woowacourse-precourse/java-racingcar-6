package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final String WORNG_CAR_LENGTH = "이름은 5자 이하만 가능해요.";

    //false일때 오류
    public void validatorForCar(List<String> cars) {
        //5자 이하인가?
        if (!isMaxSizeName(cars)) {
            throw new IllegalArgumentException(WORNG_CAR_LENGTH);
        }

    }

    public void validatorForAttemptCount(String count) {
        //0이상인가?,
        //숫자를 입력했는가?
        //한자리의 정수만을 입력했는가?

    }

    private boolean isMaxSizeName(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;

    }


}
