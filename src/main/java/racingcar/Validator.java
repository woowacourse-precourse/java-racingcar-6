package racingcar;

import java.util.List;

public class Validator {

    private static final String WORNG_CAR_LENGTH = "이름은 5자 이하만 가능해요.";
    private static final String WORNG_COUNT_RANDE = "최소 시도 횟수는 1번이에요.";

    public void validatorForCar(List<String> cars) {
        if (!isMaxSizeName(cars)) {
            throw new IllegalArgumentException(WORNG_CAR_LENGTH);
        }
    }

    public void validatorForAttemptCount(int count) {
        if (!isVaildRange(count)) {
            throw new IllegalArgumentException(WORNG_COUNT_RANDE);
        }
    }


    //region 자동자 유효 검사 Section
    private boolean isMaxSizeName(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;
    }

    //private boolean isDuplicateName
    //endregion




    //region 시도 횟수 유효 검사 Section
    private boolean isVaildRange(int count) {
        return count >= 1;
    }
    //endregion



    //중복된 이름을 입력했을 때
    //,이 2개가 연달아서 있을 때
    //공백일때
    //, 사이에 공백일 때
    //숫자가 아닌 문자를 입력했을


}
